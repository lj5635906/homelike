package com.homelike.order.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 16:51
 **/
@Entity
@Data
@Table(name = "ord_order")
public class Order {
    /**
     * 订单号
     */
    @Id
    private String orderId;
    /**
     * 买家用户id
     */
    private Long customerId;
    /**
     * 买家地址id
     */
    private Long customerShoppingAddressId;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态(1-新建,2-备货中,3-配送中,4-已签收)
     */
    private Integer orderStatus;
    /**
     * 订单状态(1-待支付,2-支持成功)
     */
    private Integer payStatus;
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
