package com.zw.cn.service.authConfig;

import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.ContentReqDTO;
import com.zw.cn.response.authConfig.ContentResponse;

import java.util.List;
import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/14 14:09
 * @desc 认证内容管理service
 */
public interface ContentService {

    /**
     * 保存认证内容
     * @param contentReqDTO 认证内容DTO实体
     */
    boolean saveContent(ContentReqDTO contentReqDTO);

    /**
     * 查询认证内容列表
     * @param contentReqDTO
     * @return
     */
    PageQueryResponse<Map> queryContentList(PageQueryRequest<ContentReqDTO> contentReqDTO);

    /**
     * 根据id查询认证内容信息
     * @param id 查询id
     * @return 认证内容信息
     */
    Map queryById(Long id);

    /**
     * 根据id更新认证内容信息
     * @param contentReqDTO 请求参数
     * @return 是否更新成功
     */
    boolean update(ContentReqDTO contentReqDTO);

    /**
     * 根据列表id查询认证内容列表
     * @param ids id列表
     * @return 认证内容列表
     */
    List<ContentResponse> queryListByIds(List<Long> ids);

}
