package com.homelike.product.common.request;

import com.homelike.common.web.valid.IntegerGreaterThanZeroValid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 商品减少库存
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-26 11:51
 **/
@Data
@ApiModel("商品减少库存请求参数")
public class ProductDecreaseStockRequest {
    /**
     * 商品Id
     */
    @ApiModelProperty("商品Id")
    @NotEmpty(message = "商品Id")
    private String productId;
    /**
     * 减少数量
     */
    @ApiModelProperty("扣除数量")
    @IntegerGreaterThanZeroValid(message = "扣除数量")
    private Integer DecreaseNumber;
}
