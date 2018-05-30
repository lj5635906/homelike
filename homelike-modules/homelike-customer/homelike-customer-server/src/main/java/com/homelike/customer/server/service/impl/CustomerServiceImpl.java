package com.homelike.customer.server.service.impl;

import com.homelike.common.core.enums.CustomerCode;
import com.homelike.common.core.enums.DeleteFlag;
import com.homelike.common.core.exception.CustomException;
import com.homelike.common.core.util.RandomUtil;
import com.homelike.customer.common.vo.CustomerVo;
import com.homelike.customer.server.entity.Customer;
import com.homelike.customer.server.entity.CustomerVerifyCode;
import com.homelike.customer.server.enums.VerifyCodeType;
import com.homelike.customer.server.repository.CustomerRepository;
import com.homelike.customer.server.repository.CustomerVerifyCodeRepository;
import com.homelike.customer.server.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 客户相关接口 实现
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 15:11
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerVerifyCodeRepository customerVerifyCodeRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void sendCode(String mobile, int type) {

        // TODO 验证该手机号是否还能继续发送短信？
        // TODO IP验证？
        // TODO 发送短信API?

        // 保存数据库
        // 获取验证码
        String code = RandomUtil.getRandom(6);
        // 获取验证码过期时间
        LocalDateTime expireTime = LocalDateTime.now().plusMinutes(10);
        CustomerVerifyCode customerVerifyCode = new CustomerVerifyCode();
        customerVerifyCode.setMobile(mobile);
        customerVerifyCode.setCodeType(type);
        customerVerifyCode.setVerifyCode(code);
        customerVerifyCode.setExpireTime(expireTime);
        customerVerifyCode.setCreateTime(new Date());
        customerVerifyCode.setUpdateTime(customerVerifyCode.getCreateTime());
        customerVerifyCode.setDeleteFlag(DeleteFlag.No.getCode());
        customerVerifyCodeRepository.save(customerVerifyCode);
    }

    @Override
    public CustomerVo findCustomerByName(String name) {
        Customer customer = customerRepository.findCustomerByCustomerName(name);
        if (null == customer){
            return null;
        }
        CustomerVo customerVo = new CustomerVo();
        BeanUtils.copyProperties(customer,customerVo);
        return customerVo;
    }

    @Override
    public CustomerVo findCustomerByMobile(String mobile) {
        Customer customer = customerRepository.findCustomerByCustomerMobile(mobile);
        if (null == customer){
            return null;
        }
        CustomerVo customerVo = new CustomerVo();
        BeanUtils.copyProperties(customer,customerVo);
        return customerVo;
    }


}
