package com.homelike.order.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 16:56
 **/
@Entity
@Data
@Table(name = "ord_order_detail")
public class OrderDetail {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 买家用户id
     */
    private Long customerId;
    /**
     * 购买数量
     */
    private Integer productQuantity;
    /**
     * 商品Id
     */
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品单价
     */
    private BigDecimal productPrice;
    /**
     * 商品描述
     */
    private String productDescribe;
    /**
     * 商品图片
     */
    private String productImage;
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
