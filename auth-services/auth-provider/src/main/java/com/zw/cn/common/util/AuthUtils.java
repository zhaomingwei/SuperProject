package com.zw.cn.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zw.cn.common.AssertUtils;
import com.zw.cn.common.constant.AuthResponseMsgConstant;
import com.zw.cn.common.constant.BestSignConstant;
import com.zw.cn.common.enums.AuthBusEnum;
import com.zw.cn.common.enums.AuthResultCodeEnum;
import com.zw.cn.config.ConfigProperties;
import com.zw.cn.response.authBus.AuthResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;

/**
 * @author 赵威
 * @date 2021/5/6 16:49
 * @desc 认证方法：个人认证，企业认证
 */
@Slf4j
@Service
public class AuthUtils {

    public static AuthUtils authUtils;

    @Autowired
    private ConfigProperties configProperties;

    @PostConstruct
    public void init(){
        authUtils = this;
    }

    /**
     * 上上签 个人2元素认证
     * @param realName 姓名
     * @param idCardNo 身份证号
     * @return 认证结果
     */
    public static AuthResultResponse personal2ElementAuth(String realName, String idCardNo){
        log.info("【AuthUtils-personal2ElementAuth】上上签个人2要素认证姓名:{},身份证号:{}", realName, idCardNo);

        AssertUtils.notBlank(AuthBusEnum.AUTH_NAME_IS_EMPTY, realName);
        AssertUtils.isTrue(AuthBusEnum.AUTH_NAME_LENGTH_INCORRECT, RegularCheckUtil.validLength(1, 10, realName));

        AssertUtils.notBlank(AuthBusEnum.AUTH_ID_CARD_NO_IS_EMPTY, idCardNo);
        AssertUtils.isTrue(AuthBusEnum.AUTH_ID_CARD_NO_INCORRECT, RegularCheckUtil.validIdCardNo(idCardNo));

        JSONObject requestBody = new JSONObject();
        requestBody.put(BestSignConstant.PERSONAL_NAME, realName);
        requestBody.put(BestSignConstant.PERSONAL_IDENTITY, idCardNo);

        String param = requestBody.toJSONString();
        String rTick = RSAUtils.getRtick();
        String paramsSign = RSAUtils.calcRsaSign(authUtils.configProperties.getBestSignDeveloperId(), authUtils.configProperties.getBestSignPrivateKey(),
                authUtils.configProperties.getBestSignServerHost(), authUtils.configProperties.getBestSignPersonalMethod(), rTick, null, param);
        String urlParams = String.format(authUtils.configProperties.getBestSignUrlSignParams(), authUtils.configProperties.getBestSignDeveloperId(), rTick, paramsSign);

        JSONObject userObj;
        try {
            String response = HttpClientSender.sendHttpPost(authUtils.configProperties.getBestSignServerHost(), authUtils.configProperties.getBestSignPersonalMethod(), urlParams, param);
            log.info("【AuthUtils-personal2ElementAuth】上上签个人2要素认证身份证号:{}, 返回结果: {}", idCardNo, response);
            if (StringUtils.isEmpty(response)) {
                return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(AuthResponseMsgConstant.AUTH_PERSONAL_2ELEMENT_RESPONSE_IS_NULL).build();
            }
            userObj = JSON.parseObject(response);
        } catch (Exception e) {
            log.error("上上签个人2要素认证异常", e);
            return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(AuthResponseMsgConstant.AUTH_PERSONAL_2ELEMENT_EXCEPTION).build();
        }

        if (userObj.getIntValue(BestSignConstant.ERRNO) == AuthResultCodeEnum.SUCCESS.getCode()) {
            JSONObject data = userObj.getJSONObject(BestSignConstant.DATA);
            if (CollectionUtils.isEmpty(data)) {
                return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(AuthResponseMsgConstant.AUTH_PERSONAL_2ELEMENT_DATA_IS_NULL).build();
            }

            if (String.valueOf(AuthResultCodeEnum.RESULT.getCode()).equals(data.getString(BestSignConstant.RESULT))) {
                return AuthResultResponse.builder().code(AuthResultCodeEnum.SUCCESS.getCode()).message(AuthResponseMsgConstant.AUTH_PERSONAL_2ELEMENT_SUCCESS).build();
            }
        }
        return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(AuthResponseMsgConstant.AUTH_PERSONAL_2ELEMENT_NOT_MATCH).build();

    }

    /**
     * 上上签 企业4要素认证 （公司认证）
     * @param enterpriseName 企业名称
     * @param blCode 营业执照编号(统一社会信用代码)
     * @param legalPersonName 法人姓名
     * @param legalPersonIdCardNo 法人身份证号码
     * @return
     */
    public static AuthResultResponse enterprise4ElementAuth(String enterpriseName, String blCode, String legalPersonName, String legalPersonIdCardNo){
        log.info("【AuthUtils-enterprise4ElementAuth】上上签企业4要素认证企业名称:{},营业执照编号:{},法人姓名:{},法人身份证号码:{}", enterpriseName, blCode, legalPersonName, legalPersonIdCardNo);

        AssertUtils.notBlank(AuthBusEnum.AUTH_ENTERPRISE_NAME_IS_EMPTY, enterpriseName);
        AssertUtils.isTrue(AuthBusEnum.AUTH_ENTERPRISE_NAME_LENGTH_INCORRECT, RegularCheckUtil.validLength(1, 30, enterpriseName));

        AssertUtils.notBlank(AuthBusEnum.AUTH_BL_CODE_IS_EMPTY, blCode);
        AssertUtils.isTrue(AuthBusEnum.AUTH_BL_CODE_LENGTH_INCORRECT, RegularCheckUtil.validLength(1, 18, blCode));

        AssertUtils.notBlank(AuthBusEnum.AUTH_LEGAL_PERSON_NAME_IS_EMPTY, legalPersonName);
        AssertUtils.isTrue(AuthBusEnum.AUTH_LEGAL_PERSON_NAME_LENGTH_INCORRECT, RegularCheckUtil.validLength(1, 10, legalPersonName));

        AssertUtils.notBlank(AuthBusEnum.AUTH_LEGAL_PERSON_ID_CARD_NO_IS_EMPTY, legalPersonIdCardNo);
        AssertUtils.isTrue(AuthBusEnum.AUTH_LEGAL_PERSON_ID_CARD_NO_INCORRECT, RegularCheckUtil.validIdCardNo(legalPersonIdCardNo));

        JSONObject requestBody = new JSONObject();
        requestBody.put(BestSignConstant.ENTERPRISE_NAME, enterpriseName);
        requestBody.put(BestSignConstant.BL_CODE_IDENTITY, blCode);
        requestBody.put(BestSignConstant.LEGAL_PERSON, legalPersonName);
        requestBody.put(BestSignConstant.LEGAL_PERSON_IDENTITY, legalPersonIdCardNo);
        requestBody.put(BestSignConstant.LEGAL_PERSON_IDENTITY_TYPE, 0);

        String param = requestBody.toJSONString();
        String rTick = RSAUtils.getRtick();
        String paramsSign = RSAUtils.calcRsaSign(authUtils.configProperties.getBestSignDeveloperId(), authUtils.configProperties.getBestSignPrivateKey(),
                authUtils.configProperties.getBestSignServerHost(), authUtils.configProperties.getBestSignEnterpriseMethod(), rTick, null, param);
        String urlParams = String.format(authUtils.configProperties.getBestSignUrlSignParams(), authUtils.configProperties.getBestSignDeveloperId(), rTick, paramsSign);

        JSONObject userObj;
        try {
            String response = HttpClientSender.sendHttpPost(authUtils.configProperties.getBestSignServerHost(), authUtils.configProperties.getBestSignEnterpriseMethod(), urlParams, param);
            log.info("【AuthUtils-enterprise4ElementAuth】上上签企业4要素认证营业执照编号:{},返回结果:{}", blCode, response);
            if (StringUtils.isEmpty(response)) {
                return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(AuthResponseMsgConstant.AUTH_ENTERPRISE_4ELEMENT_RESPONSE_IS_NULL).build();
            }
            userObj = JSON.parseObject(response);
        } catch (Exception e) {
            log.error("上上签企业4要素认证异常", e);
            return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(AuthResponseMsgConstant.AUTH_ENTERPRISE_4ELEMENT_EXCEPTION).build();
        }

        if (userObj.getIntValue(BestSignConstant.ERRNO) == AuthResultCodeEnum.SUCCESS.getCode()) {
            JSONObject data = userObj.getJSONObject(BestSignConstant.DATA);
            if (CollectionUtils.isEmpty(data)) {
                return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(AuthResponseMsgConstant.AUTH_ENTERPRISE_4ELEMENT_DATA_IS_NULL).build();
            }

            if (String.valueOf(AuthResultCodeEnum.RESULT.getCode()).equals(data.getString(BestSignConstant.RESULT))) {
                return AuthResultResponse.builder().code(AuthResultCodeEnum.SUCCESS.getCode()).message(AuthResponseMsgConstant.AUTH_ENTERPRISE_4ELEMENT_SUCCESS).build();
            }
        }

        return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(AuthResponseMsgConstant.AUTH_ENTERPRISE_4ELEMENT_FAIL).build();
    }


}
