package com.homelike.customer.common.vo;

import lombok.Data;

/**
 * 客户实体类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 14:34
 **/
@Data
public class CustomerVo {
    /**
     * 客户Id
     */
    private Long customerId;
    /**
     * 客户名
     */
    private String customerName;
    /**
     * 客户电话号码
     */
    private String customerMobile;

}
