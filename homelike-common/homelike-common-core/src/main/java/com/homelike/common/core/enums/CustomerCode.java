package com.homelike.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 16:27
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CustomerCode {

    VerifyTypeNoSupport(3000, "验证码类型暂未开放"),
    VerifyIsEmpty(3001, "未请求验证码"),
    VerifyError(3002, "验证码错误"),
    VerifyExpire(3003, "验证码已过期"),

    CustomerUnExist(3020, "客户信息不存在");
    ;
    private Integer code;
    private String message;
}
