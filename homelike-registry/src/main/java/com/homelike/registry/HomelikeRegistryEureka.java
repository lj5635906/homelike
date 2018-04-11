package com.homelike.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-19 14:55
 **/
@SpringBootApplication
@EnableEurekaServer
public class HomelikeRegistryEureka {

    public static void main(String[] args) {
        SpringApplication.run(HomelikeRegistryEureka.class);
    }

}
