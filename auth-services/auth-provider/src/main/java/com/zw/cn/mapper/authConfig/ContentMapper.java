package com.zw.cn.mapper.authConfig;

import com.zw.cn.entity.authConfig.Content;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.request.authConfig.ContentReqDTO;
import com.zw.cn.response.authConfig.ContentResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 赵威
 * @date 2021/4/14 11:34
 * @desc 认证内容Mapper
 */
@Repository
public interface ContentMapper {

    /**
     * 保存认证内容
     * @param content 认证内容实体
     * @return 插入成功条数
     */
    int insert(Content content);

    /**
     * 认证内容列表查询
     * @param pageContentReqDTO 查询参数
     * @return 认证内容列表
     */
    List<ContentResponse> queryListByParam(PageQueryRequest<ContentReqDTO> pageContentReqDTO);

    /**
     * 根据id查询认证内容信息
     * @param id 主键
     * @return 认证内容信息
     */
    ContentResponse queryById(Long id);

    /**
     * 根据id更新认证内容信息
     * @param content 更新实体
     * @return 更新成功条数
     */
    int update(Content content);

    /***
     * 列表查询 总条数
     * @param contentReqDTO 查询参数
     */
    int queryCount(PageQueryRequest<ContentReqDTO> contentReqDTO);

    /**
     * 根据名字精确查询认证内容
     * @param name 名称
     * @param id 主键
     * @return 认证内容信息
     */
    ContentResponse queryByName(String name, Long id);

    /**
     * 根据列表id查询认证内容列表
     * @param ids id列表
     * @return 认证内容列表
     */
    List<ContentResponse> queryListByIds(List<Long> ids);

}
