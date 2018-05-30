package com.homelike.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * OAuth2 client 配置文件
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-19 16:05
 **/
@Configuration
@ConfigurationProperties(prefix = "security.oauth2.client")
public class AuthServerProperties {

    private String clientId;
    private String clientSecret;
    private String scope;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
