package com.zw.cn.service.impl.authConfig.impl;

import com.alibaba.fastjson.JSON;
import com.zw.cn.common.constant.CommonConstant;
import com.zw.cn.common.enums.AuthConfigEnum;
import com.zw.cn.common.util.InputInfoCheckUtil;
import com.zw.cn.config.AuthInFieldConfig;
import com.zw.cn.core.result.JsonResult;
import com.zw.cn.entity.authConfig.Material;
import com.zw.cn.exception.ServiceException;
import com.zw.cn.mapper.authConfig.MaterialMapper;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.InputsInfoReqDTO;
import com.zw.cn.request.authConfig.MaterialReqDTO;
import com.zw.cn.response.authConfig.BusResponse;
import com.zw.cn.response.authConfig.ContentResponse;
import com.zw.cn.response.authConfig.MaterialResponse;
import com.zw.cn.service.authConfig.BusService;
import com.zw.cn.service.authConfig.ContentService;
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
 * @date 2021/4/16 10:16
 * @desc 认证材料管理
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private ContentService contentService;

    @Autowired
    private BusService busService;

    /**
     * 保存认证材料
     *
     * @param materialReqDTO 认证材料实体
     * @return 是否保存成功 true 成功 false失败
     */
    @Override
    public boolean saveMaterial(MaterialReqDTO materialReqDTO) {
        checkMaterialParam(materialReqDTO);
        Material material = Material.builder().build();
        BeanUtils.copyProperties(materialReqDTO, material);
        transferToStr(material, materialReqDTO);
        return materialMapper.insertSelective(material) > 0 ? true : false;
    }

    /**
     * 查询认证材料列表
     *
     * @param materialReqDTOPageQueryRequest
     * @return
     */
    @Override
    public PageQueryResponse<Map> queryMaterialList(PageQueryRequest<MaterialReqDTO> materialReqDTOPageQueryRequest) {
        MaterialReqDTO model = materialReqDTOPageQueryRequest.getModel();
        if (null == model) {
            model = new MaterialReqDTO();
            materialReqDTOPageQueryRequest.setModel(model);
        }
        if (null != model.getBusId()) {
            /**查询所用于业务里对应的材料id串**/
            BusResponse busResponse = busService.queryById(model.getBusId());
            if (null != busResponse && !CollectionUtils.isEmpty(busResponse.getMaterialIds())) {
                model.setMaterialIds(busResponse.getMaterialIds());
            }
        }
        // 查询总条数
        int count = materialMapper.queryCount(materialReqDTOPageQueryRequest);
        if (count < CommonConstant.INT_ONE) {
            return PageQueryResponse.createSuccessResult(null, count);
        }
        List<Material> resultList = materialMapper.queryListByParam(materialReqDTOPageQueryRequest);
        if (!CollectionUtils.isEmpty(resultList)) {
            List<MaterialResponse> responses = new ArrayList();
            for (Material material : resultList) {
                responses.add(transferToBeanList(material));
            }
            //返回字段抽取
            JsonResult jsonResult = new JsonResult();
            jsonResult.putOnlyListBean(responses, AuthInFieldConfig.AuthMaterialList_InFields);
            return PageQueryResponse.createSuccessResult((List<Map>) jsonResult.getData(), count);
        }

        return PageQueryResponse.createSuccessResult(null, count);
    }

    /**
     * 根据id查询认证材料信息
     *
     * @param id 查询id
     * @return 认证材料信息
     */
    @Override
    public Map queryById(Long id) {
        if (null == id){
            throw new ServiceException("查询id不能为空");
        }
        if (id < 1) {
            throw new ServiceException("查询id必须大于0");
        }
        Material material = materialMapper.selectByPrimaryKey(id);
        if (null != material) {
            MaterialResponse mr = transferToBeanList(material);
            //返回字段抽取
            JsonResult jsonResult = new JsonResult();
            jsonResult.putOnlyBean(mr, AuthInFieldConfig.AuthMaterialDetail_InFields);
            return (Map) jsonResult.getData();
        }
        return null;
    }

    /**
     * 根据id更新认证材料信息
     *
     * @param materialReqDTO 请求参数
     * @return 是否更新成功
     */
    @Override
    public boolean update(MaterialReqDTO materialReqDTO) {
        checkMaterialParam(materialReqDTO);
        Material material = Material.builder().build();
        BeanUtils.copyProperties(materialReqDTO, material);
        transferToStr(material, materialReqDTO);
        return materialMapper.updateByPrimaryKeySelective(material) > 0 ? true : false;
    }

    /**
     * 根据列表id查询认证材料列表
     *
     * @param ids id列表
     * @return 认证材料列表
     */
    @Override
    public List<Material> queryListByIds(List<Long> ids) {
        return materialMapper.queryListByIds(ids);
    }

    /**
     * 根据名称模糊查询认证业务列表
     *
     * @param name 认证业务名称
     * @return 认证业务列表
     */
    @Override
    public List<MaterialResponse> queryListByName(String name) {
        return materialMapper.queryListByName(name);
    }

    private MaterialResponse transferToBeanList(Material material) {
        MaterialResponse response = new MaterialResponse();
        BeanUtils.copyProperties(material, response);
        if (!StringUtils.isEmpty(material.getContentIds())) {
            response.setContentIds(Arrays.stream(material.getContentIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList()));
        }
        if (!StringUtils.isEmpty(material.getInputsInfoStr())) {
            response.setInputsInfoReqDTOS(JSON.parseArray(material.getInputsInfoStr(), InputsInfoReqDTO.class));
        }
        return response;
    }

    private void transferToStr(Material material, MaterialReqDTO materialReqDTO) {
        if (!CollectionUtils.isEmpty(materialReqDTO.getContentIds())) {
            material.setContentIds(StringUtils.join(materialReqDTO.getContentIds(), ","));
        }
        if (!CollectionUtils.isEmpty(materialReqDTO.getInputsInfoReqDTOS())) {
            material.setInputsInfoStr(JsonUtil.toString(materialReqDTO.getInputsInfoReqDTOS()));
        }
    }

    /**
     * 校验参数有效性
     *
     * @param materialReqDTO
     */
    private void checkMaterialParam(MaterialReqDTO materialReqDTO) {
        checkMaterialName(materialReqDTO);
        List<InputsInfoReqDTO> list = materialReqDTO.getInputsInfoReqDTOS();
        if (!CollectionUtils.isEmpty(list)) {
            InputInfoCheckUtil.checkVs(list);
            InputInfoCheckUtil.checkTp(list);
            InputInfoCheckUtil.checkTt(list);
        }
        checkMaterialContent(materialReqDTO);
    }

    /**
     * 校验认证材料是否存在及所选的认证内容是否有重复项
     *
     * @param materialReqDTO
     */
    private void checkMaterialContent(MaterialReqDTO materialReqDTO) {
        if (!CollectionUtils.isEmpty(materialReqDTO.getContentIds())) {
            long count = materialReqDTO.getContentIds().stream().distinct().count();
            if (count < materialReqDTO.getContentIds().size()) {
                throw new ServiceException(AuthConfigEnum.UPLOAD_CONTENT_IS_REPETITION);
            }
            List<ContentResponse> cList = contentService.queryListByIds(materialReqDTO.getContentIds());
            if (CollectionUtils.isEmpty(cList) || materialReqDTO.getContentIds().size() > cList.size()) {
                throw new ServiceException(AuthConfigEnum.AUTH_CONTENT_NOT_EXIST);
            }
        }
    }

    /**
     * 校验材料名称是否已存在
     *
     * @param materialReqDTO
     */
    private void checkMaterialName(MaterialReqDTO materialReqDTO) {
        if (null != materialMapper.queryByName(materialReqDTO.getName(), materialReqDTO.getId())) {
            throw new ServiceException(AuthConfigEnum.MATERIAL_NAME_IS_USED);
        }
    }

}
