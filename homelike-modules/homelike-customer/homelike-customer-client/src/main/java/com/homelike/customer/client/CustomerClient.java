package com.homelike.customer.client;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.customer.common.request.CustomerLoginRequest;
import com.homelike.customer.common.request.SendSmsRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 客户客户端
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 17:58
 **/
@FeignClient(
        name = "customer",
        fallback = CustomerClient.CustomerClientFallback.class
)
public interface CustomerClient {

    String CUSTOMER_PREFIX = "/customer";

    /**
     * 请求验证码
     *
     * @param request SendSmsRequest
     */
    @PostMapping(CUSTOMER_PREFIX + "/send-sms")
    ResultVo sendSms(@Valid @RequestBody SendSmsRequest request);

    /**
     * 登陆
     *
     * @param request CustomerLoginRequest
     */
    @PostMapping(CUSTOMER_PREFIX + "/login")
    ResultVo login(@Valid @RequestBody CustomerLoginRequest request);

    class CustomerClientFallback implements CustomerClient{

        @Override
        public ResultVo sendSms(SendSmsRequest request) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo login(CustomerLoginRequest request) {
            return ResultVo.hystrix();
        }
    }
}
