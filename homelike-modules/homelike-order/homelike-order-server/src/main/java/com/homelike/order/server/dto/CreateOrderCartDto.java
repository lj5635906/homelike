package com.homelike.order.server.dto;

import lombok.Data;

/**
 * 创建订单购物车Dto
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-23 16:51
 **/
@Data
public class CreateOrderCartDto {
    /**
     * 商品Id
     */
    private String productId;
    /**
     * 购买数量
     */
    private Integer productQuantity;
}
