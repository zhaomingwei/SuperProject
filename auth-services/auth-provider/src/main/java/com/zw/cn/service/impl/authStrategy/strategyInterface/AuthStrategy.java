package com.zw.cn.service.impl.authStrategy.strategyInterface;

import com.zw.cn.request.authBus.AuthBusReqDTO;
import com.zw.cn.response.authBus.AuthResultResponse;

/**
 * @author 赵威
 * @date 2021/4/27 19:25
 * @desc 认证策略接口
 */
public interface AuthStrategy {

    /**
     * 认证接口
     * @param authBusReqDTO 参数，根据不同接口使用不同参数名称
     * @return 认证结果
     */
    AuthResultResponse auth(AuthBusReqDTO authBusReqDTO);

    /**
     * 获取具体策略类型
     * @return
     */
    String getType();

}
