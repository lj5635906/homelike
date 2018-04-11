package com.homelike.product.common.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 获取商品详情数据
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 13:54
 **/
@Data
public class ProductInfoVo {
    /**
     * 商品Id
     */
    private String productId;
    /**
     * 所属商户id
     */
    private Long merchantId;
    /**
     * 商品类目id
     */
    private Long productCategoryId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品单价
     */
    private BigDecimal productPrice;
    /**
     * 商品库存
     */
    private Integer productStock;
    /**
     * 商品描述
     */
    private String productDescribe;
    /**
     * 商品图片
     */
    private String productImage;
    /**
     * 商品状态(1-正常,2-下架)
     */
    private Integer productStatus;

}
