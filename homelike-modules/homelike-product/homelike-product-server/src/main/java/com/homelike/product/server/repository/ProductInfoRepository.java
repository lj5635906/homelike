package com.homelike.product.server.repository;

import com.homelike.product.server.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品 Repository
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-21 18:02
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 根据商戶Id获取商品列表
     *
     * @param merchantId 商户Id
     * @return List<ProductInfo>
     */
    List<ProductInfo> findByMerchantId(Long merchantId);

    /**
     * 根据商户Id和状态获取商品列表
     * @param merchantId 商户Id
     * @param productStatus 商品状态(1-正常,2-下架)
     * @return List<ProductInfo>
     */
    List<ProductInfo> findByMerchantIdAndProductStatus(Long merchantId,Integer productStatus);

    /**
     * 根据商品Id集合获取商品集合
     *
     * @param productStatus 商品状态(1-正常,2-下架)
     * @param productIds 商品Id集合
     * @return List<ProductInfo>
     */
    List<ProductInfo> findByProductStatusAndProductIdIn(Integer productStatus,String...productIds);
}
