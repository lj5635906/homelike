package com.homelike.customer.server.rest;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.customer.common.request.SendSmsRequest;
import com.homelike.customer.common.vo.CustomerVo;
import com.homelike.customer.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 15:05
 **/
@RestController
@RequestMapping("/customer")
public class CustomerRest {

    @Autowired
    private CustomerService customerService;

    /**
     * 请求验证码
     *
     * @param request SendSmsRequest
     */
    @PostMapping("/send-sms")
    public ResultVo sendSms(@Valid @RequestBody SendSmsRequest request) {
        customerService.sendCode(request.getMobile(), request.getType());
        return ResultVo.ok();
    }

    /**
     * 根据用户名获取详情
     *
     * @param name 用户名
     * @return ResultVo<CustomerVo>
     */
    @PostMapping("/name/{name}")
    public ResultVo<CustomerVo> findCustomerByName(@PathVariable(name = "name") String name) {
        CustomerVo customerVo = customerService.findCustomerByName(name);
        if (null == customerVo){
            return ResultVo.dataEmpty();
        }
        return ResultVo.ok(customerVo);
    }

    /**
     * 根据电话号码获取详情
     *
     * @param mobile 电话号码
     * @return ResultVo<CustomerVo>
     */
    @PostMapping("/mobile/{mobile}")
    public ResultVo<CustomerVo> findCustomerByMobile(@PathVariable(name = "mobile") String mobile) {
        CustomerVo customerVo = customerService.findCustomerByMobile(mobile);
        if (null == customerVo){
            return ResultVo.dataEmpty();
        }
        return ResultVo.ok(customerVo);
    }
}
