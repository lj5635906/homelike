package com.homelike.product.server.service.impl;

import com.homelike.common.core.enums.BusinessCode;
import com.homelike.common.core.exception.CustomException;
import com.homelike.product.common.request.ProductDecreaseStockRequest;
import com.homelike.product.common.vo.ProductInfoVo;
import com.homelike.product.server.assembler.ProductInfoVoAssembler;
import com.homelike.product.server.entity.ProductInfo;
import com.homelike.product.server.enums.ProductStatus;
import com.homelike.product.server.repository.ProductInfoRepository;
import com.homelike.product.server.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 商品信息相关实现
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 9:41
 **/
@Service
@Slf4j
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfoVo> findByMerchantId(Long merchantId) {
        List<ProductInfo> list = productInfoRepository.findByMerchantId(merchantId);
        return ProductInfoVoAssembler.toProductInfoVo(list);
    }

    @Override
    public List<ProductInfoVo> findByMerchantIdAndProductStatus(Long merchantId, Integer productStatus) {
        if (null != productStatus) {
            List<ProductInfo> list = productInfoRepository.findByMerchantIdAndProductStatus(merchantId, productStatus);
            return ProductInfoVoAssembler.toProductInfoVo(list);
        } else {
            return this.findByMerchantId(merchantId);
        }
    }

    @Override
    @Transactional(rollbackFor = {CustomException.class, Exception.class})
    public void decreaseStock(List<ProductDecreaseStockRequest> requests) {
        for (ProductDecreaseStockRequest request : requests) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(request.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()){
                throw new CustomException(BusinessCode.ProductNotExist.getCode(),BusinessCode.ProductNotExist.getMessage());
            }
            ProductInfo productInfo = productInfoOptional.get();
            //库存是否足够
            Integer result = productInfo.getProductStock() - request.getDecreaseNumber();
            if (result < 0) {
                throw new CustomException(BusinessCode.ProductStockError.getCode(),BusinessCode.ProductStockError.getMessage());
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    public ProductInfoVo findById(String productId) {
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(productId);
        if (productInfoOptional.isPresent()) {
            ProductInfoVo productInfoVo = new ProductInfoVo();
            ProductInfo productInfo = productInfoOptional.get();
            BeanUtils.copyProperties(productInfo, productInfoVo);
            return productInfoVo;
        }
        return null;
    }

    @Override
    public List<ProductInfoVo> findByIds(String... productIds) {
        List<ProductInfo> list = productInfoRepository.findByProductStatusAndProductIdIn(ProductStatus.normal.getCode(), productIds);
        return ProductInfoVoAssembler.toProductInfoVo(list);
    }
}
