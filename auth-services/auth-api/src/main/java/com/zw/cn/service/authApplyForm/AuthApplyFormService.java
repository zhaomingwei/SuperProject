package com.zw.cn.service.authApplyForm;

import com.zw.cn.core.service.BaseService;
import com.zw.cn.entity.authBus.authApplyForm.AuthApplyForm;
import com.zw.cn.entity.authBus.authApplyForm.AuthApplyFormExample;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.request.authBus.AuthBusReqDTO;

import java.util.List;

public interface AuthApplyFormService extends BaseService<AuthApplyForm, AuthApplyFormExample, Integer> {

    /**
     * 查询认证申请单列表总数
     * @param authBusReqDTOPageQueryRequest 请求参数
     * @return 总数
     */
    int queryCount(PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest);

    /**
     * 查询认证申请单列表
     * @param authBusReqDTOPageQueryRequest 请求参数
     * @return 认证申请单列表
     */
    List<AuthApplyForm> authApplyList(PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest);

}