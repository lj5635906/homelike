package com.homelike.order.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 订单状态
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-26 11:29
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  OrderStatus {

    create(1,"新建"),
    ready(1,"备货中"),
    Distribution(1,"备货中"),
    signed (1,"已签收"),
    ;
    private Integer code;
    private String message;
}
