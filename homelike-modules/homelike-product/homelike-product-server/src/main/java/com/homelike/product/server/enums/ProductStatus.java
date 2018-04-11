package com.homelike.product.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 商品状态
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-26 10:47
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ProductStatus {
    normal(1,"正常"),
    down(2,"下架")
    ;
    private Integer code;
    private String message;
}
