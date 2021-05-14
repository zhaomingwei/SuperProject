package com.zw.cn.service.authConfig;

import com.zw.cn.entity.authConfig.Material;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.MaterialReqDTO;
import com.zw.cn.response.authConfig.MaterialResponse;

import java.util.List;
import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/16 10:12
 * @desc 认证材料Service
 */
public interface MaterialService {

    /**
     * 保存认证材料
     * @param materialReqDTO 认证材料实体
     * @return 是否保存成功 true 成功 false失败
     */
    boolean saveMaterial(MaterialReqDTO materialReqDTO);

    /**
     * 查询认证材料列表
     * @param materialReqDTO
     * @return
     */
    PageQueryResponse<Map> queryMaterialList(PageQueryRequest<MaterialReqDTO> materialReqDTO);

    /**
     * 根据id查询认证材料信息
     * @param id 查询id
     * @return 认证材料信息
     */
    Map queryById(Long id);

    /**
     * 根据id更新认证材料信息
     * @param materialReqDTO 请求参数
     * @return 是否更新成功
     */
    boolean update(MaterialReqDTO materialReqDTO);

    /**
     * 根据列表id查询认证材料列表
     * @param ids id列表
     * @return 认证材料列表
     */
    List<Material> queryListByIds(List<Long> ids);

    /**
     * 根据名称模糊查询认证证材列表
     * @param name 认证证材名称
     * @return 认证证材列表
     */
    List<MaterialResponse> queryListByName(String name);

}
