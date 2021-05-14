package com.zw.cn.controller.authBus;

import com.zw.cn.aspect.MethodLogger;
import com.zw.cn.base.BaseResult;
import com.zw.cn.base.LogTypeEnum;
import com.zw.cn.common.AssertUtils;
import com.zw.cn.common.enums.AuthBusEnum;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authBus.AuthBusReqDTO;
import com.zw.cn.request.authBus.QueryNeedAuthReqDTO;
import com.zw.cn.response.authBus.AuthResultResponse;
import com.zw.cn.response.authBus.NeedAuthBusResponse;
import com.zw.cn.service.authBus.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/26 14:34
 * @desc 认证业务controller
 */
@Api("业务认证")
@RestController
@RequestMapping("bcc/authBus")
public class AuthBusController {

    @Autowired
    private AuthService authService;

    /**
     * 根据userId,busCode查询当前用户还需要认证的项
     * @param queryNeedAuthReqDTO 请求参数
     * @return 还需要认证的项
     */
    @ApiOperation(value = "查询需认证内容")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "查询需认证内容")
    @PostMapping(value = "queryNeedAuth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<NeedAuthBusResponse> queryNeedAuth(@RequestBody QueryNeedAuthReqDTO queryNeedAuthReqDTO){
        AssertUtils.notBlank(AuthBusEnum.AUTH_BUS_CODE_IS_EMPTY, queryNeedAuthReqDTO.getBusCode());
        return BaseResult.createWebSuccessResult(authService.queryNeedAuth(queryNeedAuthReqDTO.getBusCode(), queryNeedAuthReqDTO.getUserId()));
    }

    /**
     * 根据认证业务code调用不同的认证方法
     * @param authBusReqDTO 请求参数 busCode:认证业务编码,对应AuthStrategyEnum里的code,也是t_bcc_bus表的bus_code字段内容
     * @return 认证结果
     */
    @ApiOperation(value = "业务认证接口")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "业务认证接口")
    @PostMapping(value = "auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<AuthResultResponse> auth(@RequestBody AuthBusReqDTO authBusReqDTO){
        return BaseResult.createWebSuccessResult(authService.auth(authBusReqDTO));
    }

    /**
     * 查询认证申请单列表
     * @param authBusReqDTOPageQueryRequest 请求参数
     * @return 认证申请单列表
     */
    @ApiOperation(value = "查询认证申请单列表")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "查询认证申请单列表")
    @PostMapping(value = "authApplyList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageQueryResponse<Map> authApplyList(@RequestBody PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest){
        return authService.authApplyList(authBusReqDTOPageQueryRequest);
    }

    /**
     * 根据申请单号查询认证申请单详细信息
     * @param authBusReqDTO 请求参数
     * @return 更新结果
     */
    @ApiOperation(value = "认证申请单详情查询")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "认证申请单详情查询")
    @PostMapping(value = "authApplyDetailQuery", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Map> authApplyDetailQuery(@RequestBody AuthBusReqDTO authBusReqDTO){
        AssertUtils.notBlank(AuthBusEnum.AUTH_APPLY_NO_IS_EMPTY, authBusReqDTO.getApplyNo());
        return BaseResult.createWebSuccessResult(authService.authApplyDetailQuery(authBusReqDTO));
    }

    /**
     * 根据申请单号更新认证申请单信息
     * @param authBusReqDTO 请求参数
     * @return 更新结果
     */
    @ApiOperation(value = "认证申请单更新")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "认证申请单更新")
    @PostMapping(value = "authApplyUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Boolean> authApplyUpdate(@RequestBody AuthBusReqDTO authBusReqDTO){
        AssertUtils.notBlank(AuthBusEnum.AUTH_APPLY_NO_IS_EMPTY, authBusReqDTO.getApplyNo());
        AssertUtils.notBlank(AuthBusEnum.AUTH_APPLY_STATUS_IS_EMPTY, authBusReqDTO.getApplyStatus());
        return BaseResult.createWebSuccessResult(authService.authApplyUpdate(authBusReqDTO));
    }



}
