package com.zw.cn.mapper.authConfig;

import com.zw.cn.entity.authConfig.Bus;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.request.authConfig.BusReqDTO;
import com.zw.cn.response.authConfig.BusResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc 认证业务实体
 * @author 赵威
 */
@Repository
public interface BusMapper {

    /**
     * 保存认证业务
     * @param record 保存认证业务实体
     * @return 是否保存成功
     */
    int insertSelective(Bus record);

    /**
     * 根据ID查询认证业务信息
     * @param id
     * @return
     */
    Bus selectByPrimaryKey(Long id);

    /**
     * 更新认证业务信息
     * @param record 认证业务信息
     * @return 更新成功条数
     */
    int updateByPrimaryKeySelective(Bus record);

    /**
     * 认证业务列表查询
     * @param busReqDTOPageQueryRequest 查询参数
     * @return 认证材料列表
     */
    List<Bus> queryListByParam(PageQueryRequest<BusReqDTO> busReqDTOPageQueryRequest);

    /***
     * 列表查询 总条数
     * @param busReqDTOPageQueryRequest 查询参数
     */
    int queryCount(PageQueryRequest<BusReqDTO> busReqDTOPageQueryRequest);

    /**
     * 根据名字精确查询认证业务
     * @param name 名称
     * @param id 主键
     * @return 认证业务信息
     */
    Bus queryByParam(String name, String busCode, Long id);

    /**
     * 根据名称模糊查询认证业务列表
     * @param name 认证业务名称
     * @return 认证业务列表
     */
    List<BusResponse> queryListByName(String name);

}