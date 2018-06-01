package com.homelike.common.web.vo;

import com.homelike.common.core.exception.CustomException;
import com.homelike.common.web.enums.HttpCustomStatus;
import lombok.Data;

/**
 * 所有Http请求响应基类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-20 10:18
 **/
@Data
public class ResultVo<T> {

    private ResultVo() {
    }

    private Integer code;
    private String message;
    private T data;

    /**
     * 请求成功
     *
     * @return ResultVo
     */
    public static ResultVo ok() {
        ResultVo result = new ResultVo();
        result.setCode(HttpCustomStatus.OK.getCode());
        result.setMessage(HttpCustomStatus.OK.getMessage());
        return result;
    }

    /**
     * 请求成功
     *
     * @param data Object
     * @return ResultVo
     */
    public static ResultVo ok(Object data) {
        ResultVo result = new ResultVo();
        result.setCode(HttpCustomStatus.OK.getCode());
        result.setMessage(HttpCustomStatus.OK.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 请求成功,查询无数据
     *
     * @return ResultVo
     */
    public static ResultVo dataEmpty() {
        ResultVo result = new ResultVo();
        result.setCode(HttpCustomStatus.DataEmpty.getCode());
        result.setMessage(HttpCustomStatus.DataEmpty.getMessage());
        return result;
    }

    /**
     * 参数错误
     *
     * @return ResultVo
     */
    public static ResultVo badRequest() {
        ResultVo result = new ResultVo();
        result.setCode(HttpCustomStatus.BadRequest.getCode());
        result.setMessage(HttpCustomStatus.BadRequest.getMessage());
        return result;
    }

    /**
     * 访问被拒绝
     *
     * @return ResultVo
     */
    public static ResultVo unauthorized() {
        ResultVo result = new ResultVo();
        result.setCode(HttpCustomStatus.Unauthorized.getCode());
        result.setMessage(HttpCustomStatus.Unauthorized.getMessage());
        return result;
    }

    /**
     * 服务器繁忙
     *
     * @return ResultVo
     */
    public static ResultVo serverError() {
        ResultVo result = new ResultVo();
        result.setCode(HttpCustomStatus.ServerError.getCode());
        result.setMessage(HttpCustomStatus.ServerError.getMessage());
        return result;
    }

    /**
     * 服务断路
     * @return ResultVo
     */
    public static ResultVo hystrix(){
        ResultVo result = new ResultVo();
        result.setCode(HttpCustomStatus.Hystrix.getCode());
        result.setMessage(HttpCustomStatus.Hystrix.getMessage());
        return result;
    }

    /**
     * 自定义响应数据
     *
     * @param code    响应码
     * @param message 响应提示信息
     * @return ResultVo
     */
    public static ResultVo custom(Integer code, String message) {
        ResultVo result = new ResultVo();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


    /**
     * 自定义响应数据
     *
     * @param message 响应提示信息
     * @return ResultVo
     */
    public static ResultVo custom(String message) {
        ResultVo result = new ResultVo();
        result.setCode(HttpCustomStatus.ServerError.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * 自定义响应数据
     *
     * @param code    响应码
     * @param message 响应提示信息
     * @param data    响应数据
     * @return ResultVo
     */
    public static ResultVo custom(Integer code, String message, Object data) {
        ResultVo result = new ResultVo();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 验证响应数据<有响应数据>是否合法
     *
     * @param resultVo ResultVo<?>
     * @param <T>      ?
     * @return T
     */
    public static <T> Object verifyResponse(ResultVo<?> resultVo) {
        Integer code = resultVo.getCode();
        if (code.intValue() == HttpCustomStatus.OK.getCode().intValue()) {
            return resultVo.getData();
        } else if (code.intValue() == HttpCustomStatus.DataEmpty.getCode().intValue()) {
            return null;
        } else {
            throw new CustomException(resultVo.getCode(), resultVo.getMessage());
        }
    }

    /**
     * 验证响应数据<无响应数据>是否合法
     *
     * @param resultVo ResultVo<?>
     */
    public static void verifyVoid(ResultVo resultVo) {
        Integer code = resultVo.getCode();
        if (code.intValue() != HttpCustomStatus.OK.getCode().intValue()) {
            throw new CustomException(resultVo.getCode(), resultVo.getMessage());
        }
    }

}
