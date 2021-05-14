package com.zw.cn.service.impl.authBus.impl;

import com.alibaba.fastjson.JSON;
import com.zw.cn.cache.DictCache;
import com.zw.cn.common.AssertUtils;
import com.zw.cn.common.StringUtils;
import com.zw.cn.common.constant.CommonConstant;
import com.zw.cn.common.enums.AuthBusEnum;
import com.zw.cn.common.enums.AuthDictEnum;
import com.zw.cn.common.enums.AuthResultCodeEnum;
import com.zw.cn.common.enums.AuthStrategyEnum;
import com.zw.cn.common.util.SnowflakeIdWorker;
import com.zw.cn.config.AuthInFieldConfig;
import com.zw.cn.core.result.JsonResult;
import com.zw.cn.entity.authBus.authApplyForm.AuthApplyForm;
import com.zw.cn.entity.authBus.authApplyForm.AuthApplyFormExample;
import com.zw.cn.entity.authBus.finishAuthContent.FinishAuthContent;
import com.zw.cn.entity.authBus.finishAuthContent.FinishAuthContentExample;
import com.zw.cn.entity.authConfig.Bus;
import com.zw.cn.entity.authConfig.Material;
import com.zw.cn.exception.ServiceException;
import com.zw.cn.mapper.authConfig.BusMapper;
import com.zw.cn.mapper.authConfig.ContentMapper;
import com.zw.cn.mapper.authConfig.MaterialMapper;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authBus.AuthBusReqDTO;
import com.zw.cn.request.authConfig.InputsInfoReqDTO;
import com.zw.cn.response.authBus.AuthResultResponse;
import com.zw.cn.response.authBus.NeedAuthBusResponse;
import com.zw.cn.response.authBus.NeedAuthContentResponse;
import com.zw.cn.response.authConfig.ContentResponse;
import com.zw.cn.service.authApplyForm.AuthApplyFormService;
import com.zw.cn.service.authBus.AuthService;
import com.zw.cn.service.finishAuthContent.FinishAuthContentService;
import com.zw.cn.service.impl.authStrategy.AuthStrategySelector;
import com.zw.cn.service.impl.authStrategy.strategyInterface.AuthStrategy;
import com.zw.cn.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 赵威
 * @date 2021/4/26 15:16
 * @desc TODO
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthApplyFormService authApplyFormService;

    @Autowired
    private FinishAuthContentService finishAuthContentService;

    @Autowired
    private BusMapper busMapper;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private AuthStrategySelector selector;

    private AuthStrategy authStrategy;

    /**
     * 根据userId,busCode查询当前用户还需要认证的项
     *
     * @param busCode 认证业务code(全局唯一,关联t_bcc_content表的tag_code字段)
     * @param userId  用户唯一标识,如果不为空查询之前认证过什么内容,否则查询该认证业务下配置的所有认证项
     * @return 还需要认证的项
     */
    @Override
    public NeedAuthBusResponse queryNeedAuth(String busCode, String userId) {
        List<FinishAuthContent> finishAuthContentList = null;
        NeedAuthBusResponse needAuthBusResponse = getNeedAuthBus(busCode);
        if (StringUtils.isNotBlank(userId)) {
            finishAuthContentList = getFinishAuthContent(userId);
        }
        return merge(needAuthBusResponse, finishAuthContentList);
    }

    /**
     * 业务认证接口
     *
     * @param authBusReqDTO 认证请求参数
     * @return 认证结果
     */
    @Override
    public AuthResultResponse auth(AuthBusReqDTO authBusReqDTO) {
        //1、必要参数校验
        checkParam(authBusReqDTO);
        //2、落库参数组装
        assembleParam(authBusReqDTO);
        //3、认证数据落库
        insertBusData(authBusReqDTO);
        //4、发起认证
        AuthResultResponse authResultResponse = dispatchAuth(authBusReqDTO);
        //5、根据认证结果更新认证申请单的认证状态及认证内容是否有效
        updateStatus(authBusReqDTO, authResultResponse);
        //6、需要的返回字段抽取
        JsonResult jsonResult = new JsonResult();
        jsonResult.putOnlyBean(authBusReqDTO, AuthInFieldConfig.AuthResultResponse_InFields);
        //7、返回参数组装
        AuthResultResponse response = AuthResultResponse.builder().code(authResultResponse.getCode()).message(authResultResponse.getMessage()).dataMap(((Map) jsonResult.getData())).build();
        return response;
    }

    /**
     * 认证申请单列表查询
     *
     * @param authBusReqDTOPageQueryRequest 请求参数
     * @return 认证申请单列表
     */
    @Override
    public PageQueryResponse<Map> authApplyList(PageQueryRequest<AuthBusReqDTO> authBusReqDTOPageQueryRequest) {
        AuthBusReqDTO model = authBusReqDTOPageQueryRequest.getModel();
        if (null == model) {
            model = new AuthBusReqDTO();
            authBusReqDTOPageQueryRequest.setModel(model);
        }
        // 查询总条数
        int count = authApplyFormService.queryCount(authBusReqDTOPageQueryRequest);
        if (count < CommonConstant.INT_ONE) {
            return PageQueryResponse.createSuccessResult(null, count);
        }
        List<AuthApplyForm> resultList = authApplyFormService.authApplyList(authBusReqDTOPageQueryRequest);
        //需要的返回字段抽取
        JsonResult jsonResult = new JsonResult();
        jsonResult.putOnlyListBean(resultList, AuthInFieldConfig.AuthApplyList_InFields);
        return PageQueryResponse.createSuccessResult((List<Map>) jsonResult.getData(), count);
    }

    /**
     * 根据申请单号查询认证申请单详细信息
     *
     * @param authBusReqDTO 查询参数
     */
    @Override
    public Map authApplyDetailQuery(AuthBusReqDTO authBusReqDTO) {
        AuthApplyFormExample example = new AuthApplyFormExample();
        example.createCriteria().andApplyNoEqualTo(authBusReqDTO.getApplyNo());
        AuthApplyForm authApplyForm = authApplyFormService.selectByCondition(example);

        JsonResult jsonResult = new JsonResult();
        jsonResult.putOnlyBean(authApplyForm, AuthInFieldConfig.AuthApplyDetail_InFields);
        Map resMap = (Map) jsonResult.getData();

        AssertUtils.ifTrue(() -> {
            resMap.put("authFillContent", JsonUtil.toMap((String) resMap.get("authFillContent")));
            return resMap;
        }, !CollectionUtils.isEmpty(resMap) && StringUtils.isNotBlank((String) resMap.get("authFillContent")));

        FinishAuthContentExample example1 = new FinishAuthContentExample();
        example1.createCriteria().andApplyNoEqualTo(authBusReqDTO.getApplyNo());
        List<FinishAuthContent> finishAuthContentList = finishAuthContentService.selectByExample(example1);

        AssertUtils.ifTrue(() -> {
            JsonResult jsonResult1 = new JsonResult();
            jsonResult1.putOnlyListBean(finishAuthContentList, AuthInFieldConfig.AuthApplyDetailContent_InFields);
            List<Map> contentMapList = (List<Map>) jsonResult1.getData();
            resMap.put("authContentList", contentMapList);
            return resMap;
        }, null != authApplyForm && !CollectionUtils.isEmpty(finishAuthContentList));
        return resMap;
    }

    /**
     * 根据申请单号更新认证申请单信息
     *
     * @param authBusReqDTO 请求参数
     * @return 认证申请单列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean authApplyUpdate(AuthBusReqDTO authBusReqDTO) {
        AuthApplyFormExample example = new AuthApplyFormExample();
        example.createCriteria().andApplyNoEqualTo(authBusReqDTO.getApplyNo());
        authApplyFormService.updateByExampleSelective(authBusReqDTO, example);

        FinishAuthContentExample example1 = new FinishAuthContentExample();
        example1.createCriteria().andApplyNoEqualTo(authBusReqDTO.getApplyNo());
        /**审核通过或者临时审核通过的认证内容更新为true，否则更新为false**/
        boolean flag = AuthDictEnum.APPLY_STATUS_PASS.getCode().equals(authBusReqDTO.getApplyStatus()) ||
                AuthDictEnum.APPLY_STATUS_TEMP_PASS.getCode().equals(authBusReqDTO.getApplyStatus()) ? true : false;
        finishAuthContentService.updateByExampleSelective(FinishAuthContent.builder().valid(flag).build(), example1);
        return true;
    }

    /**
     * 根据认证结果更新认证申请单状态
     *
     * @param authBusReqDTO
     * @param authResultResponse
     */
    private void updateStatus(AuthBusReqDTO authBusReqDTO, AuthResultResponse authResultResponse) {
        AuthApplyForm authApplyForm = new AuthApplyForm();
        if (AuthResultCodeEnum.SUCCESS.getCode() == authResultResponse.getCode()) {
            authApplyForm.setApplyStatus(AuthDictEnum.APPLY_STATUS_PASS.getCode());
        } else {
            authApplyForm.setApplyStatus(AuthDictEnum.APPLY_STATUS_REJECT.getCode());
        }
        /**返回更新后的状态**/
        authBusReqDTO.setApplyStatus(authApplyForm.getApplyStatus());

        authApplyForm.setAuditSug(authResultResponse.getMessage());
        AuthApplyFormExample example = new AuthApplyFormExample();
        example.createCriteria().andApplyNoEqualTo(authBusReqDTO.getApplyNo());
        authApplyFormService.updateByExampleSelective(authApplyForm, example);

        FinishAuthContentExample example1 = new FinishAuthContentExample();
        example1.createCriteria().andApplyNoEqualTo(authBusReqDTO.getApplyNo());
        /**审核通过或者临时审核通过的认证内容更新为true，否则更新为false**/
        boolean flag = AuthDictEnum.APPLY_STATUS_PASS.getCode().equals(authApplyForm.getApplyStatus()) ||
                AuthDictEnum.APPLY_STATUS_TEMP_PASS.getCode().equals(authApplyForm.getApplyStatus()) ? true : false;
        finishAuthContentService.updateByExampleSelective(FinishAuthContent.builder().valid(flag).remark(authResultResponse.getMessage()).build(), example1);
    }

    /**
     * @param authBusReqDTO
     * @desc 认证申请单及认证内容落库
     */
    private void insertBusData(AuthBusReqDTO authBusReqDTO) {
        //认证申请单信息落库
        authApplyFormService.insertSelective(authBusReqDTO);
        if (!CollectionUtils.isEmpty(authBusReqDTO.getAuthContentReqDTOList())) {
            //认证申请单里认证内容批量落库
            finishAuthContentService.batchInsert(assembleFinishAuthContent(authBusReqDTO));
        }
    }

    /**
     * 组装 认证内容 落库参数  认证前为无效的 认证成功后为有效
     *
     * @param authBusReqDTO 请求参数 TODO 断点查看ifTrue返回是否是整个方法返回
     * @return 用户已完成的认证内容实体列表
     */
    private List<FinishAuthContent> assembleFinishAuthContent(AuthBusReqDTO authBusReqDTO) {
        return authBusReqDTO.getAuthContentReqDTOList().stream().map(e -> FinishAuthContent.builder().userId(authBusReqDTO.getUserId()).applyNo(authBusReqDTO.getApplyNo())
                .authContentCode(e.getAuthContentCode()).authFileLink(e.getAuthFileLink()).valid(false).build()).collect(Collectors.toList());
    }

    /**
     * 落库参数组装 如：认证申请单，审核方式等字段
     *
     * @param authBusReqDTO 入参
     */
    private void assembleParam(AuthBusReqDTO authBusReqDTO) {
        authBusReqDTO.setApplyNo(SnowflakeIdWorker.generateApplyNo());//生成认证申请单号
        authBusReqDTO.setApplyStatus(AuthDictEnum.APPLY_STATUS_WAIT.getCode());//默认是待审核状态
        if (AuthDictEnum.AUTH_BUS_CODE_PERSONAL_CARRIER.getCode().equals(authBusReqDTO.getBusCode()) ||
                AuthDictEnum.AUTH_BUS_CODE_ENTERPRISE_CARRIER.getCode().equals(authBusReqDTO.getBusCode())) {
            authBusReqDTO.setAuditType(AuthDictEnum.AUDIT_TYPE_MANUAL.getCode());
        } else {
            authBusReqDTO.setAuditType(AuthDictEnum.AUDIT_TYPE_AUTO.getCode());//个人或者企业承运商为人工审核
        }
        authBusReqDTO.setAuthFillContent(CollectionUtils.isEmpty(authBusReqDTO.getFillContent()) ? "" : JSON.toJSONString(authBusReqDTO.getFillContent()));
    }

    /**
     * 认证申请单必要参数校验，认证需要的参数认证延迟到各个业务认证方法内
     *
     * @param authBusReqDTO
     */
    private void checkParam(AuthBusReqDTO authBusReqDTO) {
        AssertUtils.notBlank(AuthBusEnum.AUTH_USER_ID_IS_EMPTY, authBusReqDTO.getUserId());

        AssertUtils.notBlank(AuthBusEnum.AUTH_BUS_CODE_IS_EMPTY, authBusReqDTO.getBusCode());
        AssertUtils.isFalse(AuthBusEnum.AUTH_BUS_CODE_IS_NOT_EXIST, AuthStrategyEnum.get(authBusReqDTO.getBusCode()) == null);

        AssertUtils.notBlank(AuthBusEnum.AUTH_SOURCE_IS_EMPTY, authBusReqDTO.getAuthSource());
        AssertUtils.isTrue(AuthBusEnum.AUTH_SOURCE_IS_NOT_EXIST, DictCache.exist(CommonConstant.AUTH_SOURCE, authBusReqDTO.getAuthSource()));

        AssertUtils.notBlank(AuthBusEnum.AUTH_PERSON_TYPE_IS_EMPTY, authBusReqDTO.getAuthPersonType());
        AssertUtils.isTrue(AuthBusEnum.AUTH_PERSON_TYPE_IS_NOT_EXIST, DictCache.exist(CommonConstant.AUTH_PERSON_TYPE, authBusReqDTO.getAuthPersonType()));

        AssertUtils.notBlank(AuthBusEnum.AUTH_PERSON_CODE_IS_EMPTY, authBusReqDTO.getAuthPersonCode());
        AssertUtils.notBlank(AuthBusEnum.AUTH_PERSON_NAME_IS_EMPTY, authBusReqDTO.getAuthPersonName());

        AssertUtils.notBlank(AuthBusEnum.AUTH_LEGAL_PERSON_NAME_IS_EMPTY, authBusReqDTO.getAuthLegalPersonName());
        AssertUtils.notBlank(AuthBusEnum.AUTH_LEGAL_PERSON_PHONE_IS_EMPTY, authBusReqDTO.getAuthLegalPersonPhone());

        AssertUtils.notBlank(AuthBusEnum.AUTH_TYPE_IS_EMPTY, authBusReqDTO.getAuthType());
        AssertUtils.isTrue(AuthBusEnum.AUTH_TYPE_IS_NOT_EXIST, DictCache.exist(CommonConstant.AUTH_TYPE, authBusReqDTO.getAuthType()));

        AssertUtils.notBlank(AuthBusEnum.AUTH_MERCHANT_BUS_TYPE_IS_EMPTY, authBusReqDTO.getMerchantBusType());
        AssertUtils.isTrue(AuthBusEnum.AUTH_MERCHANT_BUS_TYPE_IS_NOT_EXIST, DictCache.exist(CommonConstant.MERCHANT_BUS_TYPE, authBusReqDTO.getMerchantBusType()));

        AssertUtils.notBlank(AuthBusEnum.AUTH_MERCHANT_BUS_SUB_TYPE_IS_EMPTY, authBusReqDTO.getMerchantBusSubType());
        AssertUtils.isTrue(AuthBusEnum.AUTH_MERCHANT_BUS_SUB_TYPE_IS_NOT_EXIST, DictCache.exist(CommonConstant.MERCHANT_BUS_SUB_TYPE, authBusReqDTO.getMerchantBusSubType()));
    }

    /**
     * 根据不同认证业务做认证
     *
     * @param authBusReqDTO 业务认证需要的参数 busCode:认证业务编码,对应AuthStrategyEnum里的code,也是t_bcc_bus表的bus_code字段内容
     * @return 认证结果
     */
    private AuthResultResponse dispatchAuth(AuthBusReqDTO authBusReqDTO) {
        try {
            authStrategy = selector.getAuthStrategy(authBusReqDTO.getBusCode());
            AssertUtils.notNull(AuthBusEnum.AUTH_STRATEGY_INCORRECT, authStrategy);
            return authStrategy.auth(authBusReqDTO);
        } catch (ServiceException serviceException) {
            return AuthResultResponse.builder().code(AuthResultCodeEnum.FAIL.getCode()).message(serviceException.getMessage()).build();
        }
    }

    /**
     * 合并数据
     *
     * @param needAuthBusResponse   根据业务编码查询该业务需要认证的内容
     * @param finishAuthContentList 该用户已认证的内容
     * @return 用户还需要认证的内容, 取needAuthBusResponse里的contentResponseList与finishAuthContentList的差集, 如果前者被包含于后者则说明不需要认证
     */
    private NeedAuthBusResponse merge(NeedAuthBusResponse needAuthBusResponse, List<FinishAuthContent> finishAuthContentList) {
        //该用户有已经认证内容，则从配置的该认证业务需要认证的内容中过滤掉已经认证过的内容
        AssertUtils.ifTrue(() -> {
            if (!CollectionUtils.isEmpty(needAuthBusResponse.getNeedAuthContentResponseList())) {
                List<NeedAuthContentResponse> needAuthContentResponseList = new ArrayList<>();
                boolean flag;
                for (NeedAuthContentResponse needAuthContentResponse : needAuthBusResponse.getNeedAuthContentResponseList()) {
                    flag = true;
                    for (FinishAuthContent finishAuthContent : finishAuthContentList) {
                        if (needAuthContentResponse.getTagCode().equals(finishAuthContent.getAuthContentCode())) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        needAuthContentResponseList.add(needAuthContentResponse);
                    }
                }
                needAuthBusResponse.setNeedAuthContentResponseList(needAuthContentResponseList);
            }
            return needAuthBusResponse;
        }, !CollectionUtils.isEmpty(finishAuthContentList));
        return needAuthBusResponse;
    }

    /**
     * 根据userId和busCode查询已认证的内容
     *
     * @param userId 用户id(用户唯一标识)
     * @return 已认证内容列表
     */
    private List<FinishAuthContent> getFinishAuthContent(String userId) {
        FinishAuthContentExample example = new FinishAuthContentExample();
        example.createCriteria().andUserIdEqualTo(userId).andValidEqualTo(true);
        return finishAuthContentService.selectByExample(example);
    }

    /**
     * 查询认证业务列表,包含认证材料及认证内容
     *
     * @param busCode 认证业务编码
     */
    private NeedAuthBusResponse getNeedAuthBus(String busCode) {
        NeedAuthBusResponse needAuthBusResponse = new NeedAuthBusResponse();
        List<InputsInfoReqDTO> inputsInfoReqDTOList = new ArrayList<>();
        List<NeedAuthContentResponse> needAuthContentResponseList = new ArrayList<>();
        Bus bus = busMapper.queryByParam(null, busCode, null);
        if (bus != null && StringUtils.isNotBlank(bus.getInputsInfoStr())) {
            inputsInfoReqDTOList.addAll(JSON.parseArray(bus.getInputsInfoStr(), InputsInfoReqDTO.class));
        }
        if (bus != null && StringUtils.isNotBlank(bus.getMaterialIds())) {
            List<Material> materialList = materialMapper.queryListByIds(Arrays.stream(bus.getMaterialIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList()));
            if (!CollectionUtils.isEmpty(materialList)) {
                List<Long> contentIdList = new ArrayList<>();
                for (Material material : materialList) {
                    inputsInfoReqDTOList.addAll(JSON.parseArray(material.getInputsInfoStr(), InputsInfoReqDTO.class));
                    if (StringUtils.isNotBlank(material.getContentIds())) {
                        contentIdList.addAll(Arrays.stream(material.getContentIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList()));
                    }
                }
                //内容id去重并查询
                List<ContentResponse> contentList = contentMapper.queryListByIds(contentIdList.stream().distinct().collect(Collectors.toList()));
                if (!CollectionUtils.isEmpty(contentList)) {
                    for (ContentResponse contentResponse : contentList) {
                        needAuthContentResponseList.add(NeedAuthContentResponse.builder().name(contentResponse.getName()).type(contentResponse.getType()).tagCode(contentResponse.getTagCode()).build());
                    }
                }
            }
        }
        if (!inputsInfoReqDTOList.isEmpty()) {
            needAuthBusResponse.setInputsInfoReqDTOList(inputsInfoReqDTOList);
        }
        if (!needAuthContentResponseList.isEmpty()) {
            needAuthBusResponse.setNeedAuthContentResponseList(needAuthContentResponseList);
        }
        log.info("查询需要认证内容getBus方法返回:{}", JsonUtil.toString(needAuthBusResponse));
        return needAuthBusResponse;
    }
}
