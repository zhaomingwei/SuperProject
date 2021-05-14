package com.zw.cn.common.enums;

import com.zw.cn.common.StringUtils;

/**
 * @author 赵威
 * @date 2021/4/27 19:29
 * @desc 认证策略枚举
 */
public enum AuthStrategyEnum {

    /**
     * 个人货主快速认证
     */
    PERSONAL_CARGO_OWNER_FAST_AUTH("JM000001", "个人货主快速认证！"),
    /**
     * 个人货主认证
     */
    PERSONAL_CARGO_OWNER_AUTH("JM000002", "个人货主认证！"),
    /**
     * 企业货主认证
     */
    ENTERPRISE_CARGO_OWNER_AUTH("JM000003", "企业货主认证！"),
    /**
     * 司机认证
     */
    DRIVER_AUTH("JM000004", "司机认证！"),
    /**
     * 个人承运商认证
     */
    PERSONAL_CARRIER_AUTH("JM000005", "个人承运商认证！"),
    /**
     * 企业承运商认证
     */
    ENTERPRISE_CARRIER_AUTH("JM000006", "企业承运商认证！"),
    /**
     * 车辆认证
     */
    CAR_AUTH("JM000007", "车辆认证！");

    private String code;

    private String desc;

    AuthStrategyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.desc;
    }

    public static AuthStrategyEnum get(String code){
        if (StringUtils.isBlank(code)){
            return null;
        }
        for (AuthStrategyEnum authStrategyEnum : AuthStrategyEnum.values()){
            if (code.equals(authStrategyEnum.getCode())){
                return authStrategyEnum;
            }
        }
        return null;
    }

}
