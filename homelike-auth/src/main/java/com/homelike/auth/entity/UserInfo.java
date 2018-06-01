package com.homelike.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-05-17 11:51
 **/
@Entity
@Data
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String mobile;
    private String password;
    /**
     * 用户状态（1-正常，2-锁定，3-注销）
     */
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Integer deleteFlag;
}
