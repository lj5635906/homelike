package com.homelike.common.core.exception;

/**
 * 限流-令牌异常
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-02 15:45
 **/
public class RateLimitException extends RuntimeException {

    private Integer code;

    public RateLimitException() {
        super();
    }

    public RateLimitException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
