package com.zw.cn.exception;

import com.zw.cn.base.ResultEnum;

/**
 * 服务层的异常处理
 *
 */
public class ServiceException extends RuntimeException {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 3707322958515794578L;
    /**
     * 异常代码
     */
    private String code;

    /**
     * 异常消息
     */
    private String msg;

    public ServiceException(BaseExceptionCode baseExceptionCode) {
        super(baseExceptionCode.getErrorMessage());
        this.msg = baseExceptionCode.getErrorMessage();
        this.code = baseExceptionCode.getErrorCode();
    }

    public ServiceException(String msg) {
        super(msg);
        this.msg = msg;
        this.code = ResultEnum.SYS_ERROR.getCode();
    }

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
