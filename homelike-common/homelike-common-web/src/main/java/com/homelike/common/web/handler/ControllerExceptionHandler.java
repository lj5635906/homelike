package com.homelike.common.web.handler;

import com.homelike.common.core.exception.CustomException;
import com.homelike.common.core.exception.LoginTimeOutException;
import com.homelike.common.web.vo.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


/**
 * 异常处理器
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2017-11-01 17:02
 **/
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 处理自定义异常
     * Map<String, Object>
     *
     * @param ex CustomException
     * @return ResultVo
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultVo handleCustomException(CustomException ex) {
        return ResultVo.custom(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理登陆超时异常
     *
     * @param ex LoginTimeOutException
     * @return ResultVo
     */
    @ExceptionHandler(LoginTimeOutException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultVo handleLoginTimeOutException(LoginTimeOutException ex) {
        return ResultVo.unauthorized();
    }

    /**
     * 处理 HttpMessageNotReadableException
     *
     * @param ex HttpMessageNotReadableException
     * @return 错误信息
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultVo handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResultVo.badRequest();
    }

    /**
     * 处理 MissingServletRequestParameterException , 处理RequestParam 参数校验
     *
     * @param ex MissingServletRequestParameterException
     * @return 错误信息
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultVo handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        StringBuffer message = new StringBuffer();
        message.append("[");
        message.append(ex.getParameterName() + " - " + ex.getParameterType());
        message.append("]");
        message.append(" 存在异常");
        return ResultVo.custom(HttpStatus.BAD_REQUEST.value(), message.toString());
    }

    /**
     * 处理 MethodArgumentNotValidException
     *
     * @param ex MethodArgumentNotValidException
     * @return 错误信息
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultVo handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult errors = ex.getBindingResult();
        List<ObjectError> objectErrors = errors.getAllErrors();
        if (null != objectErrors && objectErrors.size() > 0) {
            for (ObjectError error : objectErrors) {
                FieldError fieldError = (FieldError) error;
                StringBuffer message = new StringBuffer();
                message.append("[");
                message.append(fieldError.getField());
                message.append("]");
                message.append(error.getDefaultMessage());
                return ResultVo.custom(HttpStatus.BAD_REQUEST.value(), message.toString());
            }
            return ResultVo.badRequest();
        } else {
            return ResultVo.badRequest();
        }
    }

    /**
     * 处理默认Exception
     *
     * @param ex Exception
     * @return ResultVo
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultVo handleException(Exception ex) {

        return ResultVo.serverError();
    }

}
