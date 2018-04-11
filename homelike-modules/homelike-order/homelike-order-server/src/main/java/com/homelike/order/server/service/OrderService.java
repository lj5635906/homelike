package com.homelike.order.server.service;

import com.homelike.order.server.dto.CreateOrderDto;
import com.homelike.order.server.entity.Order;
import org.springframework.data.domain.Page;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 17:18
 **/
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDto 创建订单参数
     * @return 订单号
     */
    String createOrder(CreateOrderDto orderDto);

    Page<Order> page(Integer page,Integer size);
}
