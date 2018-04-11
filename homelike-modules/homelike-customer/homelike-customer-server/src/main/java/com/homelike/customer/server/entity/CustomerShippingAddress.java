package com.homelike.customer.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 客户配送地址实体类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 14:35
 **/
@Data
@Entity
@Table(name = "cus_customer_shipping_address")
public class CustomerShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_shipping_address_id;
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 国家Id
     */
    private Long country_id;
    /**
     * 国家
     */
    private String country;
    /**
     * 省份Id
     */
    private Long province_id;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市Id
     */
    private Long city_id;
    /**
     * 城市
     */
    private String city;
    /**
     * 区域Id
     */
    private Long district_id;
    /**
     * 区域
     */
    private String district;
    /**
     * 详细地址
     */
    private String address;
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
