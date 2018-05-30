package com.homelike.sso.client.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }
}
