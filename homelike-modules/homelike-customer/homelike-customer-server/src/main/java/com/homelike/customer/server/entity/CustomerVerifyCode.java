package com.homelike.customer.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 客户短信类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 14:34
 **/
@Data
@Entity
@Table(name = "cus_customer_verify_code")
public class CustomerVerifyCode {
    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 客户电话号码
     */
    private String mobile;
    /**
     * 验证码
     */
    private String verifyCode;
    /**
     * 短信类型(1-登陆)
     */
    private Integer codeType;
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志(1-未删除,2-已删除)
     */
    private Integer deleteFlag;

}
