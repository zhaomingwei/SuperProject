package com.zw.cn.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2020/5/15
 * Time: 8:59
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@Data//生成getter,setter等函数
public class Response<T> implements Serializable {
    /**
     * 响应信息
     */
    private String desc;
    /**
     * 响应code
     */
    private String code;
    /**
     * 响应结果
     */
    private T result;
    /**
     * 业务是否成功
     */
    private boolean success = false;

    public Response(T result) {
        this.result = result;
        this.success = true;
    }
}
