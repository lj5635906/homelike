package com.homelike.product.server.rest;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.product.common.vo.ProductCategoryVo;
import com.homelike.product.server.entity.ProductCategory;
import com.homelike.product.server.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品类目
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 15:26
 **/
@RestController
@RequestMapping("/product/category")
public class ProductCategoryRest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public ResultVo<List<ProductCategoryVo>> findByMerchantId(@RequestParam(name = "merchantId") Long merchantId) {
        List<ProductCategory> list = productCategoryService.findByMerchantId(merchantId);
        if (CollectionUtils.isEmpty(list)) {
            return ResultVo.dataEmpty();
        } else {
            List<ProductCategoryVo> productCategoryVoList = list.stream()
                    .map(productCategory -> {
                        ProductCategoryVo productCategoryVo = new ProductCategoryVo();
                        BeanUtils.copyProperties(productCategory, productCategoryVo);
                        return productCategoryVo;
                    }).collect(Collectors.toList());
            return ResultVo.ok(productCategoryVoList);
        }
    }
}
