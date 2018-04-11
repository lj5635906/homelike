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
public enum PayStatus {

    WaitPay(1,"待支付"),
    Success(2,"支付成功")
    ;
    private Integer code;
    private String message;
}
