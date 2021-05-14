package com.zw.cn.common.constant;

/**
 * @author 赵威
 * @date 2021/4/28 15:14
 * @desc 认证响应信息描述
 */
public class AuthResponseMsgConstant {

    public static final String AUTH_PERSONAL_2ELEMENT_SUCCESS = "个人2要素认证成功";

    public static final String AUTH_PERSONAL_2ELEMENT_EXCEPTION = "个人2要素认证异常";

    public static final String AUTH_PERSONAL_2ELEMENT_RESPONSE_IS_NULL = "个人2要素认证失败, response不能为空";

    public static final String AUTH_PERSONAL_2ELEMENT_DATA_IS_NULL = "个人2要素认证失败, data不能为空";

    public static final String AUTH_PERSONAL_2ELEMENT_NOT_MATCH = "姓名、身份证号码认证不通过，请修改信息并确保姓名、身份证号码准确无误";

    public static final String AUTH_ENTERPRISE_4ELEMENT_SUCCESS = "企业4要素认证成功";

    public static final String AUTH_ENTERPRISE_4ELEMENT_EXCEPTION = "企业4要素认证异常";

    public static final String AUTH_ENTERPRISE_4ELEMENT_RESPONSE_IS_NULL = "企业4要素认证失败, response不能为空";

    public static final String AUTH_ENTERPRISE_4ELEMENT_DATA_IS_NULL = "企业4要素认证失败, data不能为空";

    public static final String AUTH_ENTERPRISE_4ELEMENT_FAIL = "企业4要素验证失败";

}
