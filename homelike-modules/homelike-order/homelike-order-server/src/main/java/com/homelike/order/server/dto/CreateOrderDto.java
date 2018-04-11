package com.homelike.order.server.dto;

import lombok.Data;

import java.util.List;

/**
 * 创建订单Dto
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-23 16:49
 **/
@Data
public class CreateOrderDto {

    /**
     * 买家用户id
     */
    private Long customerId;
    /**
     * 买家地址id
     */
    private Long customerShoppingAddressId;
    /**
     * 购物车
     */
    private List<CreateOrderCartDto> cars;

}
