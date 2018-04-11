package com.homelike.product.client;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.product.common.vo.ProductCategoryVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品类目客户端
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 16:18
 **/
@FeignClient(
        name = "product",
        fallback = ProductCategoryClient.ProductCategoryClientFallback.class
)
public interface ProductCategoryClient {

    @GetMapping("/product/category")
    ResultVo<List<ProductCategoryVo>> findByMerchantId(@RequestParam(name = "merchantId") Long merchantId);

    @Component
    class ProductCategoryClientFallback implements ProductCategoryClient {

        @Override
        public ResultVo<List<ProductCategoryVo>> findByMerchantId(Long merchantId) {
            return ResultVo.hystrix();
        }
    }
}
