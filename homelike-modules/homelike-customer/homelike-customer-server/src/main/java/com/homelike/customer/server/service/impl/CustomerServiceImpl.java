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
    public void verifyCode(String mobile, String code, int type) {
        String dbCode = null;
        LocalDateTime expireTime = null;
        if (VerifyCodeType.login.getCode().intValue() == type) {
            CustomerVerifyCode customerVerifyCode = customerVerifyCodeRepository.findFirstByMobileAndCodeTypeOrderByCreateTimeDesc(mobile, type);
            // 是否请求验证码
            if (null == customerVerifyCode) {
                throw new CustomException(CustomerCode.VerifyIsEmpty.getCode(), CustomerCode.VerifyIsEmpty.getMessage());
            }
            expireTime = customerVerifyCode.getExpireTime();
            dbCode = customerVerifyCode.getVerifyCode();
        } else {
            throw new CustomException(CustomerCode.VerifyTypeNoSupport.getCode(), CustomerCode.VerifyTypeNoSupport.getMessage());
        }

        // 验证码是否错误
        if (!dbCode.equals(code)) {
            throw new CustomException(CustomerCode.VerifyError.getCode(), CustomerCode.VerifyError.getMessage());
        }

        // 验证码是否过期
        boolean isExpire = LocalDateTime.now().isAfter(expireTime);
        if (isExpire) {
            throw new CustomException(CustomerCode.VerifyExpire.getCode(), CustomerCode.VerifyExpire.getMessage());
        }
    }

    @Override
    public CustomerVo login(String mobile, String code) {
        // 验证验证码
        this.verifyCode(mobile, code, VerifyCodeType.login.getCode());

        // 获取客户信息
        Customer customer = customerRepository.findCustomerByCustomerMobile(mobile);
        if (null == customer) {
            //TODO 客户信息不存在-注册？
            throw new CustomException(CustomerCode.CustomerUnExist.getCode(), CustomerCode.CustomerUnExist.getMessage());
        }
        CustomerVo customerVo = new CustomerVo();
        BeanUtils.copyProperties(customer,customerVo);
        return customerVo;
    }


}
