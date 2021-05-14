package com.zw.cn.response.authBus;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class AuthResultResponse {

    /**
     * 编码
     */
    public Integer code;

    /**
     * 信息
     */
    public String message;

    /**
     * 返回数据
     */
    public Map dataMap;

}
