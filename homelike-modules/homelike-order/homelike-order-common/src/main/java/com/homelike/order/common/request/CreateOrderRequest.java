package com.homelike.order.common.request;

import com.homelike.common.web.valid.ListValid;
import com.homelike.common.web.valid.LongGreaterThanZeroValid;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * 创建订单信息
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 17:42
 **/
@Data
public class CreateOrderRequest {
    /**
     * 买家用户id
     */
    @ApiModelProperty("买家用户id")
    @LongGreaterThanZeroValid(message = "买家用户id")
    private Long customerId;
    /**
     * 买家地址id
     */
    @ApiModelProperty("买家地址id")
    @LongGreaterThanZeroValid(message = "买家地址id")
    private Long customerShoppingAddressId;
    /**
     * 购物车
     */
    @Valid // 开启对 CreateOrderCarRequest 参数的校验
    @ListValid(message = "购物车", groups = CreateOrderCarRequest.class)
    @ApiModelProperty("购物车")
    private List<CreateOrderCarRequest> cars;

}
