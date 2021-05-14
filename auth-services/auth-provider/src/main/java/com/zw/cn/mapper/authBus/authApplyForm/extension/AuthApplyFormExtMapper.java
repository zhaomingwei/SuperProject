package com.zw.cn.mapper.authBus.authApplyForm.extension;

import com.zw.cn.entity.authBus.authApplyForm.AuthApplyForm;
import com.zw.cn.mapper.authBus.authApplyForm.AuthApplyFormMapper;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.request.authBus.AuthBusReqDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthApplyFormExtMapper extends AuthApplyFormMapper {

    int queryCount(PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest);

    List<AuthApplyForm> authApplyList(PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest);

}