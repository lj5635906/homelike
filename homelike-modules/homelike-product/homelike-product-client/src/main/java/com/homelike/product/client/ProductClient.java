package com.homelike.product.client;


import com.homelike.common.web.vo.ResultVo;
import com.homelike.product.common.request.ProductDecreaseStockRequest;
import com.homelike.product.common.vo.ProductInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品客户端
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-21 16:22
 **/
@FeignClient(
        name = "product",
        fallback = ProductClient.ProductClientFallback.class
)
public interface ProductClient {

    /**
     * 商品url前缀
     */
    String PRODUCT_PREFIX = "/product";

    /**
     * 获取商品详情
     *
     * @param productId 商品Id
     * @return ResultVo<ProductInfoVo>
     */
    @GetMapping(PRODUCT_PREFIX + "/{productId}")
    ResultVo<ProductInfoVo> findProductInfo(@PathVariable(name = "productId") String productId);

    /**
     * 根据商品Id集合获取商品集合
     *
     * @param productIds 商品Id集合
     * @return ResultVo<List<ProductInfoVo>>
     */
    @PostMapping(PRODUCT_PREFIX + "/list-ids")
    ResultVo<List<ProductInfoVo>> listByProductIds(@RequestBody List<String> productIds);

    /**
     * 获取商品列表
     *
     * @param merchantId    商户Id
     * @param productStatus 商品状态
     * @return ResultVo<List<ProductInfoVo>>
     */
    @GetMapping(PRODUCT_PREFIX)
    ResultVo<List<ProductInfoVo>> list(@RequestParam(name = "merchantId") Long merchantId,
                                       @RequestParam(name = "productStatus", required = false) Integer productStatus);

    /**
     * 商品扣库存
     *
     * @param requests List<ProductDecreaseStockRequest>
     * @return ResultVo
     */
    @PostMapping(PRODUCT_PREFIX + "/decrease-stock")
    ResultVo decreaseStock(@RequestBody List<ProductDecreaseStockRequest> requests);

    /**
     * 服务熔断
     */
    @Component
    class ProductClientFallback implements ProductClient {
        @Override
        public ResultVo<ProductInfoVo> findProductInfo(String productId) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo<List<ProductInfoVo>> listByProductIds(List<String> productIds) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo<List<ProductInfoVo>> list(Long merchantId, Integer productStatus) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo decreaseStock(List<ProductDecreaseStockRequest> requests) {
            return ResultVo.hystrix();
        }
    }
}
