package com.homelike.customer.common.request;

import com.homelike.common.web.valid.IntegerGreaterThanZeroValid;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 请求验证码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 17:34
 **/
@Data
public class SendSmsRequest {

    /**
     * 电话号码
     */
    @NotBlank(message = "电话号码有异常")
    private String mobile;
    /**
     * 请求验证码类型
     */
    @IntegerGreaterThanZeroValid(message = "短信类型有异常")
    private Integer type;
}
