package com.homelike.order.common.request;

import com.homelike.common.web.valid.IntegerGreaterThanZeroValid;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 购物车信息
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 17:46
 **/
@Data
public class CreateOrderCarRequest {
    /**
     * 商品Id
     */
    @ApiModelProperty("商品Id")
    @NotEmpty(message = "商品Id")
    private String productId;
    /**
     * 购买数量
     */
    @ApiModelProperty("购买数量")
    @IntegerGreaterThanZeroValid(message = "购买数量")
    private Integer productQuantity;
}
