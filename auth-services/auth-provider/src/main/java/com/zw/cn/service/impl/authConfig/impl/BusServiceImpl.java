package com.zw.cn.service.impl.authConfig.impl;

import com.alibaba.fastjson.JSON;
import com.zw.cn.common.constant.CommonConstant;
import com.zw.cn.common.enums.AuthConfigEnum;
import com.zw.cn.common.util.InputInfoCheckUtil;
import com.zw.cn.config.AuthInFieldConfig;
import com.zw.cn.core.result.JsonResult;
import com.zw.cn.entity.authConfig.Bus;
import com.zw.cn.entity.authConfig.Material;
import com.zw.cn.exception.ServiceException;
import com.zw.cn.mapper.authConfig.BusMapper;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.BusReqDTO;
import com.zw.cn.request.authConfig.InputsInfoReqDTO;
import com.zw.cn.response.authConfig.BusResponse;
import com.zw.cn.service.authConfig.BusService;
import com.zw.cn.service.authConfig.MaterialService;
import com.zw.cn.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 赵威
 * @date 2021/4/21 11:46
 * @desc 认证业务列表管理
 */
@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusMapper busMapper;

    @Autowired
    private MaterialService materialService;

    /**
     * 保存认证业务
     *
     * @param busReqDTO 认证业务实体
     * @return 是否保存成功 true 成功 false失败
     */
    @Override
    public boolean saveBus(BusReqDTO busReqDTO) {
        checkBusParam(busReqDTO);
        Bus bus = Bus.builder().build();
        BeanUtils.copyProperties(busReqDTO, bus);
        transferToStr(bus, busReqDTO);
        return busMapper.insertSelective(bus) > 0 ? true : false;
    }

    /**
     * 查询认证业务列表
     *
     * @param busReqDTOPageQueryRequest
     * @return 认证业务列表
     */
    @Override
    public PageQueryResponse<Map> queryBusList(PageQueryRequest<BusReqDTO> busReqDTOPageQueryRequest) {
        BusReqDTO model = busReqDTOPageQueryRequest.getModel();
        if (null == model) {
            model = new BusReqDTO();
            busReqDTOPageQueryRequest.setModel(model);
        }
        /**认证业务编码不为空，精确查询，最高优先级（有填写则无视其他查询条件）**/
        if (!StringUtils.isEmpty(model.getBusCode())) {
            BusReqDTO busReqDTO = new BusReqDTO();
            busReqDTO.setBusCode(model.getBusCode());
            busReqDTOPageQueryRequest.setModel(busReqDTO);
        }
        // 查询总条数
        int count = busMapper.queryCount(busReqDTOPageQueryRequest);
        if (count < CommonConstant.INT_ONE) {
            return PageQueryResponse.createSuccessResult(null, count);
        }
        List<Bus> resultList = busMapper.queryListByParam(busReqDTOPageQueryRequest);
        if (!CollectionUtils.isEmpty(resultList)) {
            List<BusResponse> responses = new ArrayList();
            for (Bus bus : resultList) {
                responses.add(transferToBeanList(bus));
            }
            //返回字段抽取
            JsonResult jsonResult = new JsonResult();
            jsonResult.putOnlyListBean(responses, AuthInFieldConfig.AuthBusList_InFields);
            return PageQueryResponse.createSuccessResult((List<Map>) jsonResult.getData(), count);
        }
        return PageQueryResponse.createSuccessResult(null, count);
    }

    /**
     * 根据id查询认证业务信息
     *
     * @param id 查询id
     * @return 认证业务信息
     */
    @Override
    public BusResponse queryById(Long id) {
        if (null == id){
            throw new ServiceException("查询id不能为空");
        }
        if (id < 1) {
            throw new ServiceException("查询id必须大于0");
        }
        Bus bus = busMapper.selectByPrimaryKey(id);
        if (null != bus) {
            return transferToBeanList(bus);
        }
        return null;
    }

    /**
     * 根据id更新认证业务信息
     *
     * @param busReqDTO 请求参数
     * @return 是否更新成功
     */
    @Override
    public boolean update(BusReqDTO busReqDTO) {
        checkBusParam(busReqDTO);
        Bus bus = Bus.builder().build();
        BeanUtils.copyProperties(busReqDTO, bus);
        transferToStr(bus, busReqDTO);
        return busMapper.updateByPrimaryKeySelective(bus) > 0 ? true : false;
    }

    /**
     * 根据名称模糊查询认证业务列表
     *
     * @param name 认证业务名称
     * @return 认证业务列表
     */
    @Override
    public List<BusResponse> queryListByName(String name) {
        return busMapper.queryListByName(name);
    }

    private BusResponse transferToBeanList(Bus bus) {
        BusResponse response = new BusResponse();
        BeanUtils.copyProperties(bus, response);
        if (!StringUtils.isEmpty(bus.getMaterialIds())) {
            response.setMaterialIds(Arrays.stream(bus.getMaterialIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList()));
        }
        if (!StringUtils.isEmpty(bus.getCanUseItemValues())) {
            response.setCanUseItemValues(Arrays.stream(bus.getCanUseItemValues().split(",")).map(s -> s.trim()).collect(Collectors.toList()));
        }
        if (!StringUtils.isEmpty(bus.getInputsInfoStr())) {
            response.setInputsInfoReqDTOS(JSON.parseArray(bus.getInputsInfoStr(), InputsInfoReqDTO.class));
        }
        return response;
    }

    private void transferToStr(Bus bus, BusReqDTO busReqDTO) {
        if (!CollectionUtils.isEmpty(busReqDTO.getMaterialIds())) {
            bus.setMaterialIds(StringUtils.join(busReqDTO.getMaterialIds(), ","));
        }
        if (!CollectionUtils.isEmpty(busReqDTO.getCanUseItemValues())) {
            bus.setCanUseItemValues((StringUtils.join(busReqDTO.getCanUseItemValues(), ",")));
        }
        if (!CollectionUtils.isEmpty(busReqDTO.getInputsInfoReqDTOS())) {
            bus.setInputsInfoStr(JsonUtil.toString(busReqDTO.getInputsInfoReqDTOS()));
        }
    }

    /**
     * 校验参数有效性
     *
     * @param busReqDTO
     */
    private void checkBusParam(BusReqDTO busReqDTO) {
        checkBusCode(busReqDTO);
        checkBusName(busReqDTO);
        InputInfoCheckUtil.checkType(Arrays.asList(busReqDTO.getType()), AuthConfigEnum.AUTH_BUS_TYPE_NOT_EXIST);
        List<InputsInfoReqDTO> list = busReqDTO.getInputsInfoReqDTOS();
        if (!CollectionUtils.isEmpty(list)) {
            InputInfoCheckUtil.checkVs(list);
            InputInfoCheckUtil.checkTp(list);
            InputInfoCheckUtil.checkTt(list);
        }
        checkMaterial(busReqDTO);
        checkCanUseBus(busReqDTO);

    }

    /**
     * 校验 可参与业务 的有效性 是否存在及是否有重复
     *
     * @param busReqDTO
     */
    private void checkCanUseBus(BusReqDTO busReqDTO) {
        if (!CollectionUtils.isEmpty(busReqDTO.getCanUseItemValues())) {
            long count = busReqDTO.getCanUseItemValues().stream().distinct().count();
            if (count < busReqDTO.getCanUseItemValues().size()) {
                throw new ServiceException(AuthConfigEnum.CAN_USE_BUS_IS_REPETITION);
            }
            InputInfoCheckUtil.checkType(busReqDTO.getCanUseItemValues(), AuthConfigEnum.CAN_USE_BUS_NOT_EXIST);
        }
    }

    /**
     * 校验认证材料是否存在及所选的认证材料是否有重复项
     *
     * @param busReqDTO
     */
    private void checkMaterial(BusReqDTO busReqDTO) {
        if (!CollectionUtils.isEmpty(busReqDTO.getMaterialIds())) {
            long count = busReqDTO.getMaterialIds().stream().distinct().count();
            if (count < busReqDTO.getMaterialIds().size()) {
                throw new ServiceException(AuthConfigEnum.AUTH_BUS_MATERIAL_IS_REPETITION);
            }
            List<Material> mList = materialService.queryListByIds(busReqDTO.getMaterialIds());
            if (CollectionUtils.isEmpty(mList) || busReqDTO.getMaterialIds().size() > mList.size()) {
                throw new ServiceException(AuthConfigEnum.AUTH_BUS_NOT_EXIST);
            }
        }
    }

    /**
     * 校验认证业务名称是否已存在
     *
     * @param busReqDTO
     */
    private void checkBusName(BusReqDTO busReqDTO) {
        if (null != busMapper.queryByParam(busReqDTO.getName(), null, busReqDTO.getId())) {
            throw new ServiceException(AuthConfigEnum.AUTH_BUS_NAME_IS_USED);
        }
    }

    /**
     * 根据code精确查询认证任务
     *
     * @param busReqDTO
     */
    private void checkBusCode(BusReqDTO busReqDTO) {
        if (null != busMapper.queryByParam(null, busReqDTO.getBusCode(), busReqDTO.getId())) {
            throw new ServiceException(AuthConfigEnum.AUTH_BUS_CODE_IS_USED);
        }
    }

}
