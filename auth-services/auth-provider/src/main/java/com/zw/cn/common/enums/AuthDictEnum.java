package com.zw.cn.common.enums;

/**
 * @author 赵威
 * @date 2021/4/29 14:07
 * @desc 字典项枚举
 */
public enum AuthDictEnum {

    /**
     * 待审核
     */
    APPLY_STATUS_WAIT("D006001", "待审核"),

    /**
     * 临时审核通过
     */
    APPLY_STATUS_TEMP_PASS("D006002", "临时审核通过"),

    /**
     * 审核通过
     */
    APPLY_STATUS_PASS("D006003", "审核通过"),

    /**
     * 审核驳回
     */
    APPLY_STATUS_REJECT("D006004", "审核驳回"),

    /**
     * 已取消
     */
    APPLY_STATUS_CANCEL("D006005", "已取消"),

    /**
     * 自动审核
     */
    AUDIT_TYPE_AUTO("D007001", "自动审核"),

    /**
     * 人工审核
     */
    AUDIT_TYPE_MANUAL("D007002", "人工审核"),

    /**
     * 蜂羽货主APP
     */
    AUTH_SOURCE_FY_CARGO_OWNER_APP("D008001", "蜂羽货主APP"),

    /**
     * 蜂羽货主PC
     */
    AUTH_SOURCE_FY_CARGO_OWNER_PC("D008002", "蜂羽货主PC"),

    /**
     * 蜂羽货主微信小程序
     */
    AUTH_SOURCE_FY_CARGO_OWNER_WX_MINI_APP("D008003", "蜂羽货主微信小程序"),

    /**
     * 蜂羽司机APP
     */
    AUTH_SOURCE_FY_DRIVER_APP("D008004", "蜂羽司机APP"),

    /**
     * 蜂羽网络货运管理平台
     */
    AUTH_SOURCE_FY_NETWORK_MANAGE_PLAT("D008005", "蜂羽网络货运管理平台"),

    /**
     * 聚盟运营管理平台
     */
    AUTH_SOURCE_JM_MANAGE_PLAT("D008006", "聚盟运营管理平台"),

    /**
     * 个人货主快速认证
     */
    AUTH_BUS_CODE_PERSONAL_FAST("JM000001", "个人货主快速认证"),

    /**
     * 个人货主认证
     */
    AUTH_BUS_CODE_PERSONAL("JM000002", "个人货主认证"),

    /**
     * 企业货主认证
     */
    AUTH_BUS_CODE_ENTERPRISE("JM000003", "企业货主认证"),

    /**
     * 司机认证
     */
    AUTH_BUS_CODE_DRIVER("JM000004", "司机认证"),

    /**
     * 个人承运商认证
     */
    AUTH_BUS_CODE_PERSONAL_CARRIER("JM000005", "个人承运商认证"),

    /**
     * 企业承运商认证
     */
    AUTH_BUS_CODE_ENTERPRISE_CARRIER("JM000006", "企业承运商认证");

    private String code;

    private String desc;

    AuthDictEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.desc;
    }


}
