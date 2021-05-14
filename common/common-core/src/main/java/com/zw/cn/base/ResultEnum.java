package com.zw.cn.base;

import lombok.Getter;

import java.text.MessageFormat;

/**
 * 通用系统枚举
 *
 * @date 2020/5/15 9:48 上午
 */
@Getter
public enum ResultEnum {
    /**
     * 操作成功
     */
    OK("200", "操作成功"),

    /**
     * /** 参数错误
     */
    PARAM_ERROR("400", "参数错误"),

    /**
     * 熔断异常
     */
    FAIL_BACK_ERROR("FBK100012", "请求超时，请稍后重试"),

    PARAM_TYPE_ERROR("100014", "参数类型错误"),

    JSON_PARSER_ERROR("100015", "json解析错误"),

    PARSE_ERROR("100013", "参数无法解析"),

    /**
     * 系统错误
     */
    SYS_ERROR("500", "系统繁忙,请稍后重试！"),

    /**
     * token异常
     */
    TOKEN_ERROR("450", "token异常");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    ResultEnum(String code, String msg, Object... params) {
        this.code = code;
        this.msg = MessageFormat.format(msg, params);
    }

}
