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
     * 根据客户名获取详情
     *
     * @param name 名
     * @return CustomerVo
     */
    CustomerVo findCustomerByName(String name);

    /**
     * 根据电话号码获取详情
     *
     * @param mobile 电话号码
     * @return CustomerVo
     */
    CustomerVo findCustomerByMobile(String mobile);

}
