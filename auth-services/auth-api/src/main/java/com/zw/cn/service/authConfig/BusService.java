package com.zw.cn.service.authConfig;

import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.BusReqDTO;
import com.zw.cn.response.authConfig.BusResponse;

import java.util.List;
import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/21 11:46
 * @desc 认证业务列表Service
 */
public interface BusService {

    /**
     * 保存认证业务
     * @param busReqDTO 认证业务实体
     * @return 是否保存成功 true 成功 false失败
     */
    boolean saveBus(BusReqDTO busReqDTO);

    /**
     * 查询认证业务列表
     * @param busReqDTOPageQueryRequest
     * @return
     */
    PageQueryResponse<Map> queryBusList(PageQueryRequest<BusReqDTO> busReqDTOPageQueryRequest);

    /**
     * 根据id查询认证业务信息
     * @param id 查询id
     * @return 认证业务信息
     */
    BusResponse queryById(Long id);

    /**
     * 根据id更新认证业务信息
     * @param busReqDTO 请求参数
     * @return 是否更新成功
     */
    boolean update(BusReqDTO busReqDTO);

    /**
     * 根据名称模糊查询认证业务列表
     * @param name 认证业务名称
     * @return 认证业务列表
     */
    List<BusResponse> queryListByName(String name);

}
