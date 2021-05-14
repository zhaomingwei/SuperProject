package com.zw.cn.base;

import com.zw.cn.exception.BaseExceptionCode;
import com.zw.cn.exception.ServiceException;
import lombok.Data;

/**
 * 基础响应类
 * 
 * @author ZhaoWei
 * @date 2020/5/15 9:39 上午
 */
@Data
public class BaseResult<T> {
    private static final Object[] EMPTY_ARRAY = new Object[] {};

    private String code;
    private String msg;
    private T result;
    private T item;
    private boolean success;

    public BaseResult() {}

    private BaseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = ResultEnum.OK.getCode().equals(code);
    }

    private BaseResult(String code, String msg, T item) {
        this.code = code;
        this.msg = msg;
        this.item = item;
        this.result = item;
    }

    /**
     * 判断 成功/失败
     *
     * @author LiuShuang 2020-02-19
     */
    public boolean isSuccess() {
        return ResultEnum.OK.getCode().equals(code);
    }

    public void success(T result) {
        this.result = result;
        this.code = ResultEnum.OK.getCode();
        this.success = true;
    }

    public BaseResult<T> failException(ServiceException ser) {
        this.setSuccess(false);
        this.setCode(ser.getCode());
        this.setMsg(ser.getMsg());
        return this;
    }

    public BaseResult<T> fail(BaseExceptionCode errorCode) {
        this.setSuccess(false);
        this.setCode(errorCode.getErrorCode());
        this.setMsg(errorCode.getErrorMessage());
        return this;
    }

    public BaseResult<T> fail(BaseExceptionCode errorCode, String appendMessage) {
        this.setSuccess(false);
        this.setCode(errorCode.getErrorCode());
        this.setMsg(errorCode.getErrorMessage() + ":" + appendMessage);
        return this;
    }

    public BaseResult<T> successResult(T model) {
        this.setSuccess(true);
        this.setResult(model);
        this.setCode(ResultEnum.OK.getCode());
        return this;
    }

    @Deprecated
    public static <T> BaseResult<T> createResult(T result) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setCode(ResultEnum.OK.getCode());
        baseResult.setResult(result);
        baseResult.setItem(result);
        baseResult.setSuccess(Boolean.TRUE);
        return baseResult;
    };

    /**
     * 创建PC端返回结果
     * 
     * @param result
     *            返回字符
     * @param msg
     *            返回结果
     * @param <T>
     *            返回值
     * @return
     */
    public static <T> BaseResult<T> createWebSuccessResult(T result, String msg) {
        BaseResult<T> baseResult = createBaseInfo(result, msg, ResultEnum.OK.getCode(), Boolean.TRUE);
        baseResult.setResult(result);
        return baseResult;
    };

    public static <T> BaseResult<T> createWebSuccessResult(T result) {
        BaseResult<T> baseResult = createBaseInfo(result, null, ResultEnum.OK.getCode(), Boolean.TRUE);
        baseResult.setResult(result);
        return baseResult;
    };

    @Deprecated
    public static <T> BaseResult<T> createAppSuccessResult(T result) {
        BaseResult<T> baseResult = createBaseInfo(result, null, ResultEnum.OK.getCode(), Boolean.TRUE);
        baseResult.setItem(result);
        return baseResult;
    };

    private static <T> BaseResult<T> createBaseInfo(T result, String msg, String code, Boolean success) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setCode(code);
        baseResult.setMsg(msg);
        baseResult.setSuccess(success);
        return baseResult;
    };

    /**
     * 创建app返回值
     *
     * @param result
     *            返回字符
     * @param msg
     *            返回结果
     * @param <T>
     *            返回值
     * @return
     */
    public static <T> BaseResult<T> createAppSuccessResult(T result, String msg) {
        BaseResult<T> baseResult = createBaseInfo(result, msg, ResultEnum.OK.getCode(), Boolean.TRUE);
        baseResult.setItem(result);
        return baseResult;
    };

    /**
     * 构建失败结果
     * 
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> createFailResult(String msg, String code) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setCode(code);
        baseResult.setMsg(msg);
        return baseResult;
    };

    /**
     * 构建失败结果
     *
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> createFailResult(ResultEnum resultEnum) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setCode(resultEnum.getCode());
        baseResult.setMsg(resultEnum.getMsg());
        return baseResult;
    };

    /**
     * 构建错误返回结果
     * 
     * @param baseExceptionCode
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> createFailResult(BaseExceptionCode baseExceptionCode) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setCode(baseExceptionCode.getErrorCode());
        baseResult.setMsg(baseExceptionCode.getErrorMessage());
        return baseResult;
    };

    /**
     * 操作成功
     *
     * @author LiuShuang 2019-11-21
     */
    public static BaseResult createSuccessOperate() {
        return new BaseResult(ResultEnum.OK.getCode(), ResultEnum.OK.getMsg());
    }
}
