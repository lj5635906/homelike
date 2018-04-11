package com.homelike.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 业务响应码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-26 10:39
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum BusinessCode {

    CartFindEmpty(2000,"查询购物车为空"),
    ProductNotExist(2001,"商品不存在"),
    ProductStockError(2002,"商品库存不足"),
    ;
    private Integer code;
    private String message;
}
