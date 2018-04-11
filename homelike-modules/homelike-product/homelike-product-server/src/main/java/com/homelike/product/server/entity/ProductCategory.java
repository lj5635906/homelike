package com.homelike.product.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 商品类目表
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-21 18:00
 **/
@Data
@Entity
@Table(name = "pro_product_category")
public class ProductCategory {
    /**
     * 商品类目Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCategoryId;
    /**
     * 所属商户id
     */
    private Long merchantId;
    /**
     * 商品类目代码
     */
    private String categoryCode;
    /**
     * 商品类目名称
     */
    private String categoryName;
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
