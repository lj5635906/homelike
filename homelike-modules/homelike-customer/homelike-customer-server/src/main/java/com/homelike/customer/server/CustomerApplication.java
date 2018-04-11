package com.homelike.customer.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户启动主函数
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 11:48
 **/
@SpringBootApplication
@ComponentScan({"com.homelike.customer.server","com.homelike.common.web.handler"})
@EnableDiscoveryClient
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class);
    }
}
