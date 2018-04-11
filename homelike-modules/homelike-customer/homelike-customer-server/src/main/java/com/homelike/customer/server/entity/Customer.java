package com.homelike.customer.server.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 客户实体类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 14:34
 **/
@Data
@Entity
@Table(name = "cus_customer")
public class Customer {
    /**
     * 客户Id
     */
    @Id
    private Long customerId;
    /**
     * 客户名
     */
    private String customerName;
    /**
     * 客户电话号码
     */
    private String customerMobile;
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
