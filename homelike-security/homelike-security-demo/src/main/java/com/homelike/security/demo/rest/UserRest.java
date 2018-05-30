package com.homelike.security.demo.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-16 14:25
 **/
@RestController
@RequestMapping("/user")
public class UserRest {

    @GetMapping("/user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }
}
