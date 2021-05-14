package com.zw.cn.common.enums;

import com.zw.cn.exception.BaseExceptionCode;
import lombok.Getter;

/**
 * @author 赵威
 * @date 2021/4/15 15:04
 * @desc 业务认证接口相关枚举类
 */
@Getter
public enum AuthBusEnum implements BaseExceptionCode {

    /**
     * 认证业务编码不能为空
     */
    AUTH_BUS_CODE_IS_EMPTY("BCC200001", "认证业务编码不能为空！"),

    /**
     * 认证业务编码不存在
     */
    AUTH_BUS_CODE_IS_NOT_EXIST("BCC200002", "认证业务编码不存在！"),

    /**
     * 认证策略类未配置,请确认认证业务编码是否正确
     */
    AUTH_STRATEGY_INCORRECT("BCC200003", "认证策略类未配置,请确认认证业务编码是否正确！"),

    /**
     * 用户userId唯一标识不能为空
     */
    AUTH_USER_ID_IS_EMPTY("BCC200004", "用户userId唯一标识不能为空！"),

    /**
     * 认证发起端不能为空
     */
    AUTH_SOURCE_IS_EMPTY("BCC200005", "认证发起端不能为空！"),

    /**
     * 认证发起端不存在
     */
    AUTH_SOURCE_IS_NOT_EXIST("BCC200006", "认证发起端不存在！"),

    /**
     * 认证发起人类型不能为空
     */
    AUTH_PERSON_TYPE_IS_EMPTY("BCC200007", "认证发起人类型不能为空！"),

    /**
     * 认证发起人类型不存在
     */
    AUTH_PERSON_TYPE_IS_NOT_EXIST("BCC200008", "认证发起人类型不存在！"),

    /**
     * 认证发起人编码不能为空
     */
    AUTH_PERSON_CODE_IS_EMPTY("BCC200009", "认证发起人编码不能为空！"),

    /**
     * 认证发起人名称不能为空
     */
    AUTH_PERSON_NAME_IS_EMPTY("BCC200010", "认证发起人名称不能为空！"),

    /**
     * 法人名称不能为空
     */
    AUTH_LEGAL_PERSON_NAME_IS_EMPTY("BCC200011", "法人名称不能为空！"),

    /**
     * 法人手机号不能为空
     */
    AUTH_LEGAL_PERSON_PHONE_IS_EMPTY("BCC200012", "法人手机号不能为空！"),

    /**
     * 认证类型不能为空
     */
    AUTH_TYPE_IS_EMPTY("BCC200013", "认证类型不能为空！"),

    /**
     * 认证类型不存在
     */
    AUTH_TYPE_IS_NOT_EXIST("BCC200014", "认证类型不存在！"),

    /**
     * 客商业务类型不能为空
     */
    AUTH_MERCHANT_BUS_TYPE_IS_EMPTY("BCC200015", "客商业务类型不能为空！"),

    /**
     * 客商业务类型不存在
     */
    AUTH_MERCHANT_BUS_TYPE_IS_NOT_EXIST("BCC200016", "客商业务类型不存在！"),

    /**
     * 客商业务子类型不能为空
     */
    AUTH_MERCHANT_BUS_SUB_TYPE_IS_EMPTY("BCC200017", "客商业务子类型不能为空！"),

    /**
     * 客商业务子类型不存在
     */
    AUTH_MERCHANT_BUS_SUB_TYPE_IS_NOT_EXIST("BCC200018", "客商业务子类型不存在！"),

    /**
     * 认证申请单号不能为空
     */
    AUTH_APPLY_NO_IS_EMPTY("BCC200019", "认证申请单号不能为空！"),

    /**
     * 认证申请单号不能为空
     */
    AUTH_APPLY_STATUS_IS_EMPTY("BCC200020", "认证申请单状态不能为空！"),


    /**
     * 认证要素不能为空
     */
    AUTH_ELEMENT_IS_EMPTY("BCC200021", "认证要素不能为空！"),

    /**
     * 姓名不能为空
     */
    AUTH_NAME_IS_EMPTY("BCC200022", "姓名不能为空！"),

    /**
     * 姓名长度1-10位
     */
    AUTH_NAME_LENGTH_INCORRECT("BCC200023", "姓名长度1-10位！"),

    /**
     * 身份证号码不能为空
     */
    AUTH_ID_CARD_NO_IS_EMPTY("BCC200024", "身份证号码不能为空！"),

    /**
     * 身份证号码不正确
     */
    AUTH_ID_CARD_NO_INCORRECT("BCC200025", "身份证号码不正确！"),

    /**
     * 企业名称不能为空
     */
    AUTH_ENTERPRISE_NAME_IS_EMPTY("BCC200026", "企业名称不能为空！"),

    /**
     * 企业名称长度1-30位
     */
    AUTH_ENTERPRISE_NAME_LENGTH_INCORRECT("BCC200027", "企业名称长度1-30位！"),

    /**
     * 营业执照编号(统一社会信用代码)不能为空
     */
    AUTH_BL_CODE_IS_EMPTY("BCC200028", "营业执照编号不能为空！"),

    /**
     * 营业执照编号(统一社会信用代码)长度1-18位
     */
    AUTH_BL_CODE_LENGTH_INCORRECT("BCC200029", "营业执照编号长度1-18位！"),

    /**
     * 法人姓名长度1-10位
     */
    AUTH_LEGAL_PERSON_NAME_LENGTH_INCORRECT("BCC200030", "法人姓名长度1-10位！"),

    /**
     * 法人身份证号码不能为空
     */
    AUTH_LEGAL_PERSON_ID_CARD_NO_IS_EMPTY("BCC200031", "法人身份证号码不能为空！"),

    /**
     * 法人身份证号码不正确
     */
    AUTH_LEGAL_PERSON_ID_CARD_NO_INCORRECT("BCC200032", "法人身份证号码不正确！");

    private String code;

    private String desc;

    AuthBusEnum(String code, String desc) {
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
