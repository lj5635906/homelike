package com.homelike.customer.client;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.customer.common.request.SendSmsRequest;
import com.homelike.customer.common.vo.CustomerVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
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
     * 根据用户名获取详情
     *
     * @param name 用户名
     * @return ResultVo<CustomerVo>
     */
    @PostMapping(CUSTOMER_PREFIX + "/name/{name}")
    ResultVo<CustomerVo> findCustomerByName(@PathVariable(name = "name") String name);

    /**
     * 根据电话号码获取详情
     *
     * @param mobile 电话号码
     * @return ResultVo<CustomerVo>
     */
    @PostMapping(CUSTOMER_PREFIX + "/mobile/{mobile}")
    ResultVo<CustomerVo> findCustomerByMobile(@PathVariable(name = "mobile") String mobile);

    class CustomerClientFallback implements CustomerClient {

        @Override
        public ResultVo sendSms(SendSmsRequest request) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo<CustomerVo> findCustomerByName(String name) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo<CustomerVo> findCustomerByMobile(String mobile) {
            return ResultVo.hystrix();
        }

    }
}
