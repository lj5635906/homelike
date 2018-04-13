package com.homelike.product.server.rest;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.product.common.request.ProductDecreaseStockRequest;
import com.homelike.product.common.vo.ProductInfoVo;
import com.homelike.product.server.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api("商品相关接口")
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
    @ApiOperation(value = "获取商品详情", notes = "根据商品Id获取")
    @GetMapping("/{productId}")
    public ResultVo<ProductInfoVo> findProductInfo(
            @ApiParam(name = "productId", value = "商品Id", required = true) @PathVariable(name = "productId") String productId) {
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
    @ApiOperation(value = "获取商品列表", notes = "根据商户Id或者商品状态")
    @GetMapping
    public ResultVo<List<ProductInfoVo>> list(
            @ApiParam(name = "merchantId", value = "商户Id", required = true) @RequestParam(name = "merchantId") Long merchantId,
            @ApiParam(name = "productStatus", value = "商品状态", required = true) @RequestParam(name = "productStatus", required = false) Integer productStatus) {
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
    @ApiOperation(value = "获取商品集合", notes = "根据商品Id集合")
    @PostMapping("/list-ids")
    public ResultVo<List<ProductInfoVo>> listByProductIds(
            @ApiParam(name = "productIds", value = "商品Id集合", required = true) @RequestBody List<String> productIds) {
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
    @ApiOperation(value = "商品扣库存")
    @PostMapping("/decrease-stock")
    public ResultVo decreaseStock(@RequestBody List<ProductDecreaseStockRequest> requests) {
        productInfoService.decreaseStock(requests);
        return ResultVo.ok();
    }


}
