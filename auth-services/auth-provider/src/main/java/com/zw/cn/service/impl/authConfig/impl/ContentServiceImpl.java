package com.zw.cn.service.impl.authConfig.impl;

import com.zw.cn.common.constant.CommonConstant;
import com.zw.cn.common.enums.AuthConfigEnum;
import com.zw.cn.common.util.InputInfoCheckUtil;
import com.zw.cn.config.AuthInFieldConfig;
import com.zw.cn.core.result.JsonResult;
import com.zw.cn.entity.authConfig.Content;
import com.zw.cn.exception.ServiceException;
import com.zw.cn.mapper.authConfig.ContentMapper;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.ContentReqDTO;
import com.zw.cn.response.authConfig.ContentResponse;
import com.zw.cn.service.authConfig.ContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/14 14:45
 * @desc 认证内容管理Service实现类
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    /**
     * 保存认证内容
     * @param contentReqDTO 认证内容DTO实体
     */
    @Override
    public boolean saveContent(ContentReqDTO contentReqDTO) {
        checkContentParam(contentReqDTO);
        Content content = new Content();
        BeanUtils.copyProperties(contentReqDTO, content);
        return contentMapper.insert(content) > 0 ? true : false;
    }

    /**
     * 查询认证内容列表
     * @param contentReqDTOPageQueryRequest
     * @return
     */
    @Override
    public PageQueryResponse<Map> queryContentList(PageQueryRequest<ContentReqDTO> contentReqDTOPageQueryRequest) {
        ContentReqDTO model = contentReqDTOPageQueryRequest.getModel();
        if (null == model) {
            model = new ContentReqDTO();
            contentReqDTOPageQueryRequest.setModel(model);
        }
        // 查询总条数
        int count = contentMapper.queryCount(contentReqDTOPageQueryRequest);
        if (count < CommonConstant.INT_ONE) {
            return PageQueryResponse.createSuccessResult(null, count);
        }
        List<ContentResponse> resultList = contentMapper.queryListByParam(contentReqDTOPageQueryRequest);
        //返回字段抽取
        JsonResult jsonResult = new JsonResult();
        jsonResult.putOnlyListBean(resultList, AuthInFieldConfig.AuthContentList_InFields);
        return PageQueryResponse.createSuccessResult((List<Map>) jsonResult.getData(), count);
    }

    /**
     * 根据id查询认证内容信息
     * @param id 查询id
     * @return 认证内容信息
     */
    @Override
    public Map queryById(Long id) {
        if (null == id){
            throw new ServiceException("查询id不能为空");
        }
        if (id < 1){
            throw new ServiceException("查询id必须大于0");
        }
        ContentResponse contentResponse = contentMapper.queryById(id);
        if (contentResponse == null){
            return new HashMap();
        }
        //返回字段抽取
        JsonResult jsonResult = new JsonResult();
        jsonResult.putOnlyBean(contentResponse, AuthInFieldConfig.AuthContentDetail_InFields);
        return (Map) jsonResult.getData();
    }

    /**
     * 根据id更新认证内容信息
     * @param contentReqDTO 请求参数
     * @return 是否更新成功
     */
    @Override
    public boolean update(ContentReqDTO contentReqDTO) {
        checkContentParam(contentReqDTO);
        Content content = new Content();
        BeanUtils.copyProperties(contentReqDTO, content);
        return contentMapper.update(content) > 0 ? true : false;
    }

    /**
     * 根据列表id查询认证内容列表
     * @param ids id列表
     * @return 认证内容列表
     */
    @Override
    public List<ContentResponse> queryListByIds(List<Long> ids){
        return contentMapper.queryListByIds(ids);
    }

    /**
     * 校验参数有效性
     * @param contentReqDTO
     */
    private void checkContentParam(ContentReqDTO contentReqDTO) {
        InputInfoCheckUtil.checkType(Arrays.asList(contentReqDTO.getType()), AuthConfigEnum.CONTENT_TYPE_NOT_EXIST);
        if (null != contentMapper.queryByName(contentReqDTO.getName(), contentReqDTO.getId())){
            throw new ServiceException(AuthConfigEnum.CONTENT_NAME_IS_USED);
        }
    }

}
