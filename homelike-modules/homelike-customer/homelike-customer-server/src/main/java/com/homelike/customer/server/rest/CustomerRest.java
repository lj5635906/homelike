package com.homelike.customer.server.rest;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.customer.common.request.CustomerLoginRequest;
import com.homelike.customer.common.request.SendSmsRequest;
import com.homelike.customer.common.vo.CustomerVo;
import com.homelike.customer.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 登陆
     * @param request CustomerLoginRequest
     */
    @PostMapping("/login")
    public ResultVo login(@Valid @RequestBody CustomerLoginRequest request){
        CustomerVo customerVo = customerService.login(request.getMobile(),request.getCode());
        return ResultVo.ok(customerVo);
    }

}
