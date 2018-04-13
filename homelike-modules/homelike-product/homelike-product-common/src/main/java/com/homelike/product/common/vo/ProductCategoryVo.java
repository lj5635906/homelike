package com.homelike.product.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品类目
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 15:31
 **/
@Data
public class ProductCategoryVo {
    /**
     * 商品类目Id
     */
    @ApiModelProperty("商品类目Id")
    private Long productCategoryId;
    /**
     * 所属商户id
     */
    @ApiModelProperty("所属商户id")
    private Long merchantId;
    /**
     * 商品类目代码
     */
    @ApiModelProperty("商品类目代码")
    private String categoryCode;
    /**
     * 商品类目名称
     */
    @ApiModelProperty("商品类目名称")
    private String categoryName;
}
