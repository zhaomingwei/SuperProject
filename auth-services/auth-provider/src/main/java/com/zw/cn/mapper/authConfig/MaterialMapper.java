package com.zw.cn.mapper.authConfig;

import com.zw.cn.entity.authConfig.Material;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.request.authConfig.MaterialReqDTO;
import com.zw.cn.response.authConfig.MaterialResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 认证材料清单Mapper
 */
@Repository
public interface MaterialMapper {

    /**
     * 保存认证材料信息
     * @param record 认证材料信息
     * @return 保存成功条数
     */
    int insertSelective(Material record);

    /**
     * 认证材料列表查询
     * @param pageTBccMaterialReqDTO 查询参数
     * @return 认证材料列表
     */
    List<Material> queryListByParam(PageQueryRequest<MaterialReqDTO> pageTBccMaterialReqDTO);

    /**
     * 根据ID查询认证材料信息
     * @param id
     * @return
     */
    Material selectByPrimaryKey(Long id);

    /**
     * 更新认证材料信息
     * @param record 认证材料信息
     * @return 更新成功条数
     */
    int updateByPrimaryKeySelective(Material record);

    /***
     * 列表查询 总条数
     * @param materialReqDTOPageQueryRequest 查询参数
     */
    int queryCount(PageQueryRequest<MaterialReqDTO> materialReqDTOPageQueryRequest);

    /**
     * 根据名字精确查询认证材料
     * @param name 名称
     * @param id 主键
     * @return 认证材料信息
     */
    Material queryByName(String name, Long id);

    /**
     * 根据列表id查询认证材料列表
     * @param ids id列表
     * @return 认证材料列表
     */
    List<Material> queryListByIds(List<Long> ids);

    /**
     * 根据名称模糊查询认证材料列表
     * @param name 认证材料名称
     * @return 认证材料列表
     */
    List<MaterialResponse> queryListByName(String name);

}