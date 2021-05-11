package com.zw.cn.common;

import com.zw.cn.core.result.JsonResult;
import com.zw.cn.exception.BaseException;

/**
 * @author
 */
public class ExceptionUtils {
    public static void throwSimpleEx(int code) {
        throw new BaseException(code);
    }

    public static void throwSimpleEx(JsonResult jsonResult) {
        throw new BaseException(jsonResult);
    }

    public static void throwSimpleEx(int code, Object... args) {
        throw new BaseException(code, args);
    }

    public static void throwSimpleEx(int code, String msg) {
        throw new BaseException(code, msg);
    }

    public static void throwError(int code) {
        throw new BaseException(code);
    }

    public static void throwError(JsonResult jsonResult) {
        throw new BaseException(jsonResult);
    }

    public static void throwError(int code, Object... args) {
        throw new BaseException(code, args);
    }

    public static void throwError(int code, String msg) {
        throw new BaseException(code, msg);
    }

    /**
     * 默认900:内部错误
     *
     * @throws BaseException
     * @version 2015年8月6日下午2:17:50
     */
    public static void throwError() throws BaseException {
        throw new BaseException(900);
    }

}
