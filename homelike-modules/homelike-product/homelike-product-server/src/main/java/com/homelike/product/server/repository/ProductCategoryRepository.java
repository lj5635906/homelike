package com.homelike.product.server.repository;

import com.homelike.product.server.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-21 18:03
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    /**
     * 根据商户Id获取所有商品类目
     *
     * @param merchantId 商户Id
     * @return List<ProductCategory>
     */
    List<ProductCategory> findByMerchantId(Long merchantId);
}
