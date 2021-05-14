package com.zw.cn.common.enums;

import com.zw.cn.exception.BaseExceptionCode;
import lombok.Getter;

/**
 * @author 赵威
 * @date 2021/4/15 15:04
 * @desc 认证业务配置枚举类
 */
@Getter
public enum AuthConfigEnum implements BaseExceptionCode {

    /***
     * 参数不能为空
     */
    PARAM_IS_NOT_NULL("BCC100201", "参数不能为空！"),

    /***
     * 查询结果为空
     */
    QUERY_RESULT_IS_NULL("BCC100202", "查询结果为空！"),

    /**
     * 内容类型不存在
     */
    CONTENT_TYPE_NOT_EXIST("BCC100203", "内容类型不存在！"),

    /**
     * 内容名称已使用
     */
    CONTENT_NAME_IS_USED("BCC100204", "该内容名称已被使用！"),

    /**
     * 材料名称已使用
     */
    MATERIAL_NAME_IS_USED("BCC100205", "该材料名称已被使用！"),

    /**
     * 信息标题不能重复
     */
    MSG_TITLE_IS_REPETITION("BCC100206", "信息标题不能重复！"),

    /**
     * 信息输入控件不存在
     */
    INPUTS_INFO_NOT_EXIST("BCC100207", "信息输入控件不存在！"),

    /**
     * 校验策略不存在
     */
    VERIFY_STRATEGY_NOT_EXIST("BCC100208", "校验策略不存在！"),

    /**
     * 认证内容不存在
     */
    AUTH_CONTENT_NOT_EXIST("BCC100209", "认证内容不存在！"),

    /**
     * 上传内容不能重复
     */
    UPLOAD_CONTENT_IS_REPETITION("BCC100210", "上传内容不能重复！"),

    /**
     * 认证业务名称已使用
     */
    AUTH_BUS_NAME_IS_USED("BCC100211", "认证业务名称已被使用！"),

    /**
     * 认证业务编码已使用
     */
    AUTH_BUS_CODE_IS_USED("BCC100212", "认证业务编码已被使用！"),

    /**
     * 认证类型不存在
     */
    AUTH_BUS_TYPE_NOT_EXIST("BCC100213", "认证类型不存在！"),

    /**
     * 认证材料清单不能重复
     */
    AUTH_BUS_MATERIAL_IS_REPETITION("BCC100214", "认证材料清单不能重复！"),

    /**
     * 认证材料不存在
     */
    AUTH_BUS_NOT_EXIST("BCC100215", "认证材料不存在！"),

    /**
     * 认证通过后可参与业务不能重复
     */
    CAN_USE_BUS_IS_REPETITION("BCC100216", "认证通过后可参与业务不能重复！"),

    /**
     * 认证通过后可参与业务不存在
     */
    CAN_USE_BUS_NOT_EXIST("BCC100217", "认证通过后可参与业务不存在！");

    private String code;

    private String desc;

    AuthConfigEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMessage() {
        return this.desc;
    }

}
