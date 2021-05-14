package com.zw.cn.service.authBus;

import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authBus.AuthBusReqDTO;
import com.zw.cn.response.authBus.AuthResultResponse;
import com.zw.cn.response.authBus.NeedAuthBusResponse;

import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/26 15:14
 * @desc 认证业务service
 */
public interface AuthService {

    /**
     * 根据userId,busCode查询当前用户还需要认证的项
     * @param busCode 认证业务code(全局唯一,关联t_bcc_content表的tag_code字段)
     * @param userId 用户唯一标识,如果不为空查询之前认证过什么内容,否则查询该认证业务下配置的所有认证项
     * @return 还需要认证的项
     */
    NeedAuthBusResponse queryNeedAuth(String busCode, String userId);

    /**
     * 业务认证接口
     * @param authBusReqDTO 业务认证需要的参数
     * @return 认证结果
     */
    AuthResultResponse auth(AuthBusReqDTO authBusReqDTO);

    /**
     * 认证申请单列表查询
     * @param authBusReqDTOPageQueryRequest 请求参数
     * @return 认证申请单列表
     */
    PageQueryResponse<Map> authApplyList(PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest);

    /**
     * 根据申请单号查询认证申请单详细信息
     * @param authBusReqDTO 查询参数
     */
    Map authApplyDetailQuery(AuthBusReqDTO authBusReqDTO);

    /**
     * 根据申请单号更新认证申请单信息
     * @param authBusReqDTO 请求参数
     * @return 更新结果
     */
    boolean authApplyUpdate(AuthBusReqDTO authBusReqDTO);
}
