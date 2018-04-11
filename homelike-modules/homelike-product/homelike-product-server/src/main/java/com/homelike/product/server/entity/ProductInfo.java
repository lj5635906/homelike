package com.homelike.product.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品类实体
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-21 17:30
 **/
@Data
@Entity
@Table(name = "pro_product_info")
public class ProductInfo {

    /**
     * 商品Id
     */
    @Id
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志(1-未删除,2-已删除)
     */
    private Integer deleteFlag;
}
