package com.zw.cn.exception;

import java.text.MessageFormat;

/**
 * @author ZhaoWei
 */
public class ServiceExtException extends ServiceException {


    public ServiceExtException(BaseExceptionCode baseExceptionCode) {
        super(baseExceptionCode);
    }

    public ServiceExtException(String code, String msg) {
        super(code, msg);
    }

    public ServiceExtException(BaseExceptionCode baseCode, Object... args) {
        this(baseCode.getErrorCode(), MessageFormat.format(baseCode.getErrorMessage(), args));
    }
}
