package com.homelike.order.server.service.impl;

import com.homelike.common.core.enums.BusinessCode;
import com.homelike.common.core.enums.DeleteFlag;
import com.homelike.common.core.exception.CustomException;
import com.homelike.common.core.util.sequence.DistributedSequence;
import com.homelike.common.core.util.sequence.ISequence;
import com.homelike.common.web.vo.ResultVo;
import com.homelike.order.server.dto.CreateOrderCartDto;
import com.homelike.order.server.dto.CreateOrderDto;
import com.homelike.order.server.entity.Order;
import com.homelike.order.server.entity.OrderDetail;
import com.homelike.order.server.enums.OrderStatus;
import com.homelike.order.server.enums.PayStatus;
import com.homelike.order.server.repository.OrderDetailRepository;
import com.homelike.order.server.repository.OrderRepository;
import com.homelike.order.server.service.OrderService;
import com.homelike.product.client.ProductClient;
import com.homelike.product.common.request.ProductDecreaseStockRequest;
import com.homelike.product.common.vo.ProductInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单服务
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 17:18
 **/
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 简单的分布式Id
     */
    private ISequence sequence = new DistributedSequence("0", 4);
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional(rollbackFor = {CustomException.class, Exception.class})
    public String createOrder(CreateOrderDto orderDto) {

        // 获取购物车Id集合
        List<String> productIds = orderDto.getCars().stream()
                .map(createOrderCartDto -> createOrderCartDto.getProductId())
                .collect(Collectors.toList());
        // 获取购物车商品集合
        ResultVo<List<ProductInfoVo>> resultProductInfoVo = productClient.listByProductIds(productIds);
        // 集合结果校验
        List<ProductInfoVo> productInfoVos = (List<ProductInfoVo>) ResultVo.verifyResponse(resultProductInfoVo);
        if (CollectionUtils.isEmpty(productInfoVos)) {
            throw new CustomException(BusinessCode.CartFindEmpty.getCode(), BusinessCode.CartFindEmpty.getMessage());
        }
        if (productIds.size() != productInfoVos.size()) {
            // TODO 返回下架商品信息
            throw new CustomException(BusinessCode.CartFindEmpty.getCode(), BusinessCode.CartFindEmpty.getMessage());
        }

        Order order = new Order();
        // 获取订单号
        order.setOrderId(sequence.next());
        order.setCustomerId(orderDto.getCustomerId());
        order.setCustomerShoppingAddressId(orderDto.getCustomerShoppingAddressId());
        order.setOrderStatus(OrderStatus.create.getCode());
        order.setPayStatus(PayStatus.WaitPay.getCode());
        order.setCreateTime(new Date());
        order.setUpdateTime(order.getCreateTime());
        order.setDeleteFlag(DeleteFlag.No.getCode());

        // 计算总价  保存订单明细
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (CreateOrderCartDto cartDto : orderDto.getCars()) {
            for (ProductInfoVo productInfoVo : productInfoVos) {
                if (cartDto.getProductId().equals(productInfoVo.getProductId())) {
                    // 保存订单明细
                    OrderDetail orderDetail = new OrderDetail();
                    BeanUtils.copyProperties(productInfoVo, orderDetail);
                    orderDetail.setOrderId(order.getOrderId());
                    orderDetail.setCustomerId(order.getCustomerId());
                    orderDetail.setProductQuantity(cartDto.getProductQuantity());
                    orderDetail.setCreateTime(new Date());
                    orderDetail.setUpdateTime(orderDetail.getCreateTime());
                    orderDetail.setDeleteFlag(DeleteFlag.No.getCode());
                    orderDetailRepository.save(orderDetail);

                    // 单价 * 数量
                    orderAmount = productInfoVo.getProductPrice()
                            .multiply(new BigDecimal(cartDto.getProductQuantity()))
                            .add(orderAmount);
                }
            }
        }

        // 商品扣库存
        List<ProductDecreaseStockRequest> requests = orderDto.getCars().stream()
                .map(cartDto -> {
                    ProductDecreaseStockRequest request = new ProductDecreaseStockRequest();
                    request.setDecreaseNumber(cartDto.getProductQuantity());
                    request.setProductId(cartDto.getProductId());
                    return request;
                }).collect(Collectors.toList());
        ResultVo resultVo = productClient.decreaseStock(requests);
        ResultVo.verifyVoid(resultVo);

        // 保存订单
        orderRepository.save(order);

        return order.getOrderId();
    }

    @Override
    public Page<Order> page(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");
        return orderRepository.findAll(pageable);
    }
}
