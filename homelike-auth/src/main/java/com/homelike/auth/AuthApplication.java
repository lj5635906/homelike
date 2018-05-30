package com.homelike.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * SSO  -  Authorization Server 认证服务器
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-19 14:42
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.homelike.common.web.handler","com.homelike.customer.client"})
@EnableFeignClients(basePackages = {"com.homelike.customer.client"})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

}
