package com.zw.cn.exception;

import com.zw.cn.base.ResultEnum;

/**
 * @author
 */
public class ExceptionUtils {


    public static void throwSimpleEx() {
        throw new ServiceException(ResultEnum.SYS_ERROR.getMsg(), ResultEnum.SYS_ERROR.getCode());
    }

    public static void throwError() {
        throw new ServiceException(ResultEnum.SYS_ERROR.getMsg(), ResultEnum.SYS_ERROR.getCode());
    }

    public static void throwSimpleEx(BaseExceptionCode baseCode) {
        if (baseCode == null)
            throwSimpleEx();
        throw new ServiceExtException(baseCode);
    }

    public static void throwSimpleEx(BaseExceptionCode baseCode, Object... args) {
        if (baseCode == null)
            throwSimpleEx();
        throw new ServiceExtException(baseCode, args);
    }

    public static void throwError(BaseExceptionCode baseCode) {
        if (baseCode == null)
            throwError();
        throw new ServiceExtException(baseCode);
    }

}
