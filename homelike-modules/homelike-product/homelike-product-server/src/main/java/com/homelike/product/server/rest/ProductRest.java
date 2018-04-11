package com.homelike.product.server.rest;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.product.common.request.ProductDecreaseStockRequest;
import com.homelike.product.common.vo.ProductInfoVo;
import com.homelike.product.server.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 商品相关服务
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 13:57
 **/
@RestController
@RequestMapping("/product")
public class ProductRest {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 获取商品详情
     *
     * @param productId 商品Id
     * @return ResultVo<ProductInfoVo>
     */
    @GetMapping("/{productId}")
    public ResultVo<ProductInfoVo> findProductInfo(@PathVariable(name = "productId") String productId) {
        ProductInfoVo productInfoVo = productInfoService.findById(productId);
        Optional<ProductInfoVo> productInfoOptional = Optional.ofNullable(productInfoVo);
        if (productInfoOptional.isPresent()) {
            return ResultVo.ok(productInfoVo);
        }
        return ResultVo.dataEmpty();
    }

    /**
     * 获取商品列表
     *
     * @param merchantId    商户Id
     * @param productStatus 商品状态
     * @return ResultVo<List<ProductInfoVo>>
     */
    @GetMapping
    public ResultVo<List<ProductInfoVo>> list(@RequestParam(name = "merchantId") Long merchantId,
                                              @RequestParam(name = "productStatus", required = false) Integer productStatus) {
        List<ProductInfoVo> list = productInfoService.findByMerchantIdAndProductStatus(merchantId, productStatus);
        if (CollectionUtils.isEmpty(list)) {
            return ResultVo.dataEmpty();
        } else {
            return ResultVo.ok(list);
        }
    }

    /**
     * 根据商品Id集合获取商品集合
     *
     * @param productIds 商品Id集合
     * @return ResultVo<List<ProductInfoVo>>
     */
    @PostMapping("/list-ids")
    public ResultVo<List<ProductInfoVo>> listByProductIds(@RequestBody List<String> productIds) {
        List<ProductInfoVo> list = productInfoService.findByIds(productIds.toArray(new String[]{}));
        if (CollectionUtils.isEmpty(list)) {
            return ResultVo.dataEmpty();
        } else {
            return ResultVo.ok(list);
        }
    }

    /**
     * 商品扣库存
     *
     * @param requests List<ProductDecreaseStockRequest>
     * @return ResultVo
     */
    @PostMapping("/decrease-stock")
    public ResultVo decreaseStock(@RequestBody List<ProductDecreaseStockRequest> requests) {
        productInfoService.decreaseStock(requests);
        return ResultVo.ok();
    }


}
