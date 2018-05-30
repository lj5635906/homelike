package com.homelike.auth.service;

import com.homelike.auth.util.UserDetailsImpl;
import com.homelike.common.web.vo.ResultVo;
import com.homelike.customer.client.CustomerClient;
import com.homelike.customer.common.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 认证获取认证用户信息
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-19 16:50
 **/
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerClient customerClient;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        ResultVo<CustomerVo> vo = customerClient.findCustomerByName(username);
        CustomerVo customerVo = (CustomerVo) ResultVo.verifyResponse(vo);
        return new UserDetailsImpl(customerVo);
    }
}
