package com.zw.cn.service.impl.authStrategy.strategyInterface;

import com.zw.cn.common.AssertUtils;
import com.zw.cn.common.constant.AuthRequestConstant;
import com.zw.cn.common.enums.AuthBusEnum;
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
 * @date 2021/5/7 10:32
 * @desc 司机认证
 */
@Slf4j
@Service
public class DriverAuthStrategy implements AuthStrategy {

    /**
     * 司机认证
     * @param authBusReqDTO 参数，realName:姓名，idCardNo:身份证号码
     * @return 认证结果
     */
    @Override
    public AuthResultResponse auth(AuthBusReqDTO authBusReqDTO) {
        log.info("【司机认证】使用上上签个人2要素认证参数:{}", JsonUtil.toString(authBusReqDTO.getFillContent()));
        Map map = authBusReqDTO.getFillContent();
        AssertUtils.isFalse(AuthBusEnum.AUTH_ELEMENT_IS_EMPTY, CollectionUtils.isEmpty(map));

        AuthResultResponse authResultResponse = AuthUtils.personal2ElementAuth(map.get(AuthRequestConstant.REAL_NAME) == null ? "" : (String) map.get(AuthRequestConstant.REAL_NAME),
                map.get(AuthRequestConstant.ID_CARD_NO) == null ? "" : (String) map.get(AuthRequestConstant.ID_CARD_NO));
        log.info("【司机认证】使用上上签个人2要素认证姓名:{},身份证号:{},认证结果:{}", map.get(AuthRequestConstant.REAL_NAME), map.get(AuthRequestConstant.ID_CARD_NO), JsonUtil.toString(authResultResponse));
        return authResultResponse;
    }

    @Override
    public String getType() {
        return AuthStrategyEnum.DRIVER_AUTH.getCode();
    }
}
