package com.homelike.customer.server.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 短信验证码类型
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 17:44
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum VerifyCodeType {

    login(1, "登陆"),
    ;
    private Integer code;
    private String message;
}
