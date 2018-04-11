package com.homelike.product.server.service.impl;

import com.homelike.product.server.entity.ProductCategory;
import com.homelike.product.server.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 13:42
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findByMerchantId() {
        List<ProductCategory> data = productCategoryService.findByMerchantId(1L);
        System.out.println(data.toString());
    }

}