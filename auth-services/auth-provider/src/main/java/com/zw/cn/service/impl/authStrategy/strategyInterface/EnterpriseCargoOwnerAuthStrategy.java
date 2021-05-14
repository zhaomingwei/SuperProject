package com.zw.cn.service.impl.authStrategy.strategyInterface;

import com.zw.cn.common.AssertUtils;
import com.zw.cn.common.constant.AuthRequestConstant;
import com.zw.cn.common.enums.AuthBusEnum;
import com.zw.cn.common.enums.AuthResultCodeEnum;
import com.zw.cn.common.enums.AuthStrategyEnum;
import com.zw.cn.common.util.AuthUtils;
import com.zw.cn.request.authBus.AuthBusReqDTO;
import com.zw.cn.response.authBus.AuthResultResponse;
import com.zw.cn.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @author 赵威
 * @date 2021/5/6 19:32
 * @desc 企业货主认证
 */
@Slf4j
@Service
public class EnterpriseCargoOwnerAuthStrategy implements AuthStrategy {

    @Override
    public AuthResultResponse auth(AuthBusReqDTO authBusReqDTO) {
        log.info("【企业货主认证】认证参数:{}", JsonUtil.toString(authBusReqDTO));
        Map map = authBusReqDTO.getFillContent();
        AssertUtils.isFalse(AuthBusEnum.AUTH_ELEMENT_IS_EMPTY, CollectionUtils.isEmpty(map));

        /**个人（管理员）2要素认证结果**/
        AuthResultResponse personalAuthResultResponse = AuthUtils.personal2ElementAuth(map.get(AuthRequestConstant.REAL_NAME) == null ? "" : (String) map.get(AuthRequestConstant.REAL_NAME),
                map.get(AuthRequestConstant.ID_CARD_NO) == null ? "" : (String) map.get(AuthRequestConstant.ID_CARD_NO));
        if (AuthResultCodeEnum.SUCCESS.getCode() != personalAuthResultResponse.getCode()){
            log.info("【企业货主认证】使用上上签个人2要素认证身份证号:{},认证结果:{}", map.get(AuthRequestConstant.ID_CARD_NO), JsonUtil.toString(personalAuthResultResponse));
            return personalAuthResultResponse;
        }

        /**企业4要素认证结果**/
        AuthResultResponse enterpriseAuthResultResponse = AuthUtils.enterprise4ElementAuth(map.get(AuthRequestConstant.ENTERPRISE_NAME) == null ? "" : (String) map.get(AuthRequestConstant.ENTERPRISE_NAME),
                map.get(AuthRequestConstant.BL_CODE) == null ? "" : (String) map.get(AuthRequestConstant.BL_CODE),
                map.get(AuthRequestConstant.LEGAL_PERSON_NAME) == null ? "" : (String) map.get(AuthRequestConstant.LEGAL_PERSON_NAME),
                map.get(AuthRequestConstant.LEGAL_PERSON_ID_CARD_NO) == null ? "" : (String) map.get(AuthRequestConstant.LEGAL_PERSON_ID_CARD_NO));

        log.info("【企业货主认证】使用上上签企业4要素营业执照编号{},认证结果:{}", map.get(AuthRequestConstant.BL_CODE), JsonUtil.toString(enterpriseAuthResultResponse));
        return enterpriseAuthResultResponse;
    }

    @Override
    public String getType() {
        return AuthStrategyEnum.ENTERPRISE_CARGO_OWNER_AUTH.getCode();
    }
}
