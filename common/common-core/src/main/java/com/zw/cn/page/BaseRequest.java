package com.zw.cn.page;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * BaseRequest
 *
 * @author ZhaoWei
 * @date 2020/5/28 16:39 上午
 */
public class BaseRequest<T> implements Serializable {

    /**
     * 业务参数
     */
    @Valid
    protected T model;

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
