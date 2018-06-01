package com.homelike.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 不需要鉴权的URL
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-05-31 10:51
 **/
@Configuration
@ConfigurationProperties(prefix = "authentication.urls")
public class AnonProperties {

    private List<String> anon = new ArrayList<>();

    public List<String> getAnon() {
        return anon;
    }

    public void setAnon(List<String> anon) {
        this.anon = anon;
    }
}
