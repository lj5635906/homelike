package com.homelike.common.core.exception;

public class LoginTimeOutException extends RuntimeException {
    public LoginTimeOutException() {
        super("登陆超时！");
    }

    public LoginTimeOutException(String message) {
        super(message);
    }

    public LoginTimeOutException(String message, Throwable cause) {
        super(message, cause);
    }
}