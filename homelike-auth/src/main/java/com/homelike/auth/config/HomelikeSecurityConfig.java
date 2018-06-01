package com.homelike.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * homelike Spring Security 相关配置
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-19 16:50
 **/
@Configuration
public class HomelikeSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AnonProperties anonProperties;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler securityAuthenticationFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                // 需要身份认证时跳转的URL
                .loginPage("/authentication/require")
                // 自定义登陆请求
                .loginProcessingUrl("/authentication/form")
                .successHandler(securityAuthenticationSuccessHandler)
                .failureHandler(securityAuthenticationFailureHandler);

        http
                .authorizeRequests()
                .antMatchers(anonProperties.getAnon().toArray(new String[]{}))
                .permitAll()
                .anyRequest()
                .authenticated();

        http
                .csrf()
                .disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
