package com.homelike.product.server.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-29 10:37
 **/
@RestController
@RequestMapping("/properties")
public class PropertiesRest {

    @Value("${label}")
    private String label;

    @GetMapping
    public String getProperties(){
        return label;
    }

}
