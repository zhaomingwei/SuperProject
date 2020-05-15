package com.zw.cn.common;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2020/5/15
 * Time: 9:23
 * To change this template use File | Settings | File Templates.
 * Description:
 * 1000～1999 区间表示参数错误
 * 2000～2999 区间表示用户错误
 * 3000～3999 区间表示接口异常
 */
public enum ConstantEnum {

    SUCCESS("0", "success"),
    FAILED("1", "failed"),

    COMMON_ACCOUNT_ERROR("1001", "账号错误"),
    COMMON_TOKEN_ERROR("1002", "token已过期"),
    COMMON_PARAM_EMPTY("1003", "必选参数为空"),
    COMMON_PARAM_ERROR("1004", "参数格式错误"),

    FILE_NOT_EXIST("1101", "文件不存在"),

    SYSTEM_UNKNOWN_ERROR("-1", "系统繁忙，请稍后再试....");

    private String code;
    private String desc;

    ConstantEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ConstantEnum{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
