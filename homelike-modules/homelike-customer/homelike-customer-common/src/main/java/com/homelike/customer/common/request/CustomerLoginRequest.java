package com.homelike.customer.common.request;

import com.homelike.common.web.valid.IntegerGreaterThanZeroValid;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 请求验证码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 17:34
 **/
@Data
public class CustomerLoginRequest {

    /**
     * 电话号码
     */
    @NotBlank(message = "电话号码有异常")
    private String mobile;
    /**
     * 验证码
     */
    @NotBlank(message = "验证码有异常")
    private String code;
}
