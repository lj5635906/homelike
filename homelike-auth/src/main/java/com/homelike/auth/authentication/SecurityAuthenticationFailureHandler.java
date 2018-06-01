/**
 *
 */
package com.homelike.auth.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homelike.common.web.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆失败处理器
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2017-11-23 9:40
 **/
@Component("securityAuthenticationFailureHandler")
public class SecurityAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        logger.info("登录失败");

        if (exception instanceof BadCredentialsException){
            logger.info("密码错误");
        }else if (exception instanceof UsernameNotFoundException){
            logger.info("该账户不存在");
        }else if (exception instanceof LockedException){
            logger.info("账户被锁定");
        }else if (exception instanceof CredentialsExpiredException){
            logger.info("密码过期");
        }else if (exception instanceof AccountExpiredException){
            logger.info("账户过期");
        }

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(ResultVo.custom(exception.getMessage())));

    }

}
