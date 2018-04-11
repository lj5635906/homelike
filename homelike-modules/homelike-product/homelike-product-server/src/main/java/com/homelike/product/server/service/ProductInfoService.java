package com.homelike.product.server.service;

import com.homelike.product.common.request.ProductDecreaseStockRequest;
import com.homelike.product.common.vo.ProductInfoVo;
import com.homelike.product.server.entity.ProductInfo;

import java.util.List;
import java.util.Optional;

/**
 * 商品信息相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 9:40
 **/
public interface ProductInfoService {

    /**
     * 根据Id获取商品详情
     *
     * @param productId 商品Id
     * @return ProductInfoVo
     */
    ProductInfoVo findById(String productId);

    /**
     * 根据商品Id集合获取商品集合
     *
     * @param productIds 商品Id集合
     * @return List<ProductInfoVo>
     */
    List<ProductInfoVo> findByIds(String... productIds);

    /**
     * 根据商戶Id获取商品列表
     *
     * @param merchantId 商户Id
     * @return List<ProductInfoVo>
     */
    List<ProductInfoVo> findByMerchantId(Long merchantId);

    /**
     * 根据商户Id和状态获取商品列表
     *
     * @param merchantId    商户Id
     * @param productStatus 商品状态(1-正常,2-下架)
     * @return List<ProductInfoVo>
     */
    List<ProductInfoVo> findByMerchantIdAndProductStatus(Long merchantId, Integer productStatus);

    /**
     * 商品扣除库存
     *
     * @param requests List<ProductDecreaseStockRequest>
     */
    void decreaseStock(List<ProductDecreaseStockRequest> requests);
}
