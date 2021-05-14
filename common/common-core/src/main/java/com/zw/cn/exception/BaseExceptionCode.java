package com.zw.cn.exception;

/**
 * @author ZhaoWei
 * @date 2020/5/18 12:00 下午
 */
public interface BaseExceptionCode {

    /**
     * 错误码
     * 
     * @return
     */
    String getErrorCode();

    /**
     * 错误信息
     * 
     * @return
     */
    String getErrorMessage();
}
