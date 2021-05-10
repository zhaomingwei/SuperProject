package com.zw.cn.exception;

import com.zw.cn.core.result.JsonResult;
import com.zw.cn.core.result.MsgConfig;

public class BaseException extends RuntimeException {
    private int code;
    private JsonResult jsonResult;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public JsonResult getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(JsonResult jsonResult) {
        this.jsonResult = jsonResult;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause,
                         boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(int code) {
        super(MsgConfig.getMsg(code));
        this.code = code;
    }

    public BaseException(int code, Object... args) {
        super(MsgConfig.getMsg(code, args));
        this.code = code;
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BaseException(JsonResult jsonResult) {
        super(jsonResult.getMsg());
        this.jsonResult = jsonResult;
    }

}
