package com.homelike.product.server.service.impl;

import com.homelike.product.server.entity.ProductCategory;
import com.homelike.product.server.repository.ProductCategoryRepository;
import com.homelike.product.server.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 10:08
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByMerchantId(Long merchantId) {
        return productCategoryRepository.findByMerchantId(merchantId);
    }
}
