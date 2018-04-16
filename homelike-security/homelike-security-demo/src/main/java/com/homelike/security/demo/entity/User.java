package com.homelike.security.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-16 14:26
 **/
@Data
public class User {
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 生日
     */
    private LocalDateTime birthday;
    /**
     * 性别
     */
    private Integer gender;

}
