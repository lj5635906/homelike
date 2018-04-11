package com.homelike.customer.server.service;

import com.homelike.customer.common.vo.CustomerVo;
import com.homelike.customer.server.entity.Customer;

/**
 * 客户相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 15:10
 **/
public interface CustomerService {

    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @param type   验证码类型
     */
    void sendCode(String mobile, int type);

    /**
     * 验证验证码
     *
     * @param mobile 手机号码
     * @param code   验证码
     * @param type   验证码类型
     */
    void verifyCode(String mobile, String code, int type);

    /**
     * 客户登陆
     * @param mobile 电话号码
     * @param code 验证码
     * @return CustomerVo
     */
    CustomerVo login(String mobile,String code);
}
