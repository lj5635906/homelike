package com.homelike.common.web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Http自定义响应码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-20 10:44
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum HttpCustomStatus {

    Hystrix(100, "服务开启断路器模式"),
    OK(200, "请求成功!"),
    DataEmpty(201, "请求成功,查询无数据"),
    BadRequest(400, "参数错误"),
    Unauthorized (401, "访问被拒绝"),
    ServerError (500, "服务器繁忙"),
    ;
    private Integer code;
    private String message;

}
