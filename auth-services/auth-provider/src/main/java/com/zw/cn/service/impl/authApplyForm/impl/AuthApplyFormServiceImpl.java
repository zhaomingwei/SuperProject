package com.zw.cn.service.impl.authApplyForm.impl;

import com.zw.cn.core.service.impl.BaseServiceImpl;
import com.zw.cn.entity.authBus.authApplyForm.AuthApplyForm;
import com.zw.cn.entity.authBus.authApplyForm.AuthApplyFormExample;
import com.zw.cn.mapper.authBus.authApplyForm.AuthApplyFormMapper;
import com.zw.cn.mapper.authBus.authApplyForm.extension.AuthApplyFormExtMapper;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.request.authBus.AuthBusReqDTO;
import com.zw.cn.service.authApplyForm.AuthApplyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthApplyFormServiceImpl extends BaseServiceImpl<AuthApplyForm, AuthApplyFormExample, Integer> implements AuthApplyFormService {

    @Autowired
    public AuthApplyFormMapper authApplyFormMapper;

    @Autowired
    public AuthApplyFormExtMapper authApplyFormExtMapper;

    @Autowired
    public void setMapper() {
        super.setMapper(authApplyFormMapper);
    }

    @Override
    public int queryCount(PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest) {
        return authApplyFormExtMapper.queryCount(authBusReqDTOPageQueryRequest);
    }

    @Override
    public List<AuthApplyForm> authApplyList(PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest) {
        return authApplyFormExtMapper.authApplyList(authBusReqDTOPageQueryRequest);
    }
}