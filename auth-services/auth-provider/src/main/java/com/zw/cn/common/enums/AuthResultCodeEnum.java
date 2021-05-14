package com.zw.cn.common.enums;

import lombok.Getter;

/**
 * 响应码
 * @author 赵威
 */
@Getter
public enum AuthResultCodeEnum {

    /**
     * SUCCESS
     */
    SUCCESS(0, "成功"),

    /**
     * RESULT
     */
    RESULT(1, "成功"),

    /**
     * FAIL
     */
    FAIL(-1, "失败");

    /**
     * 返回码
     */
    private final int code;

    /**
     * 描述
     */
    private final String desc;

    AuthResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
