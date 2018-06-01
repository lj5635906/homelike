package com.homelike.auth.service;

import com.homelike.auth.entity.UserInfo;
import com.homelike.auth.reposityory.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 认证获取认证用户信息
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-19 16:50
 **/
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登陆用户名： {}", username);
        return buildUser(null, username);
    }

    private UserDetails buildUser(String userId, String username) {
        UserInfo userInfo = null;
        if (StringUtils.isEmpty(userId)) {
            userInfo = repository.findByUsernameOrMobile(username, username);
        } else {
            repository.findById(Long.valueOf(userId));
        }
        if (null == userInfo) {
            throw new UsernameNotFoundException("用户信息不存在.");
        }
        // 账户是否可用
        boolean enabled = true;
        if (userInfo.getDeleteFlag().intValue() != 0) {
            enabled = false;
        }
        // 账户是否过期
        boolean accountNonExpired = true;
        // 密码是否过期
        boolean credentialsNonExpired = true;
        // 账户是否锁定
        boolean accountNonLocked = true;
        if (userInfo.getStatus().intValue() == 2) {
            accountNonLocked = false;
        }
        // 授权
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER");
        return new User(userInfo.getUsername(), userInfo.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
