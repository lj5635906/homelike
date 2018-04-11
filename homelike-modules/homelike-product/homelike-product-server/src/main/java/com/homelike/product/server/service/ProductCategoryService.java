package com.homelike.product.server.service;

import com.homelike.product.server.entity.ProductCategory;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 10:07
 **/
public interface ProductCategoryService {

    /**
     * 根据商户Id获取所有商品类目
     *
     * @param merchantId 商户Id
     * @return List<ProductCategory>
     */
    List<ProductCategory> findByMerchantId(Long merchantId);
}
