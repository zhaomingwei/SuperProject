package com.zw.cn.controller.authConfig;

import com.zw.cn.aspect.MethodLogger;
import com.zw.cn.base.BaseResult;
import com.zw.cn.base.LogTypeEnum;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.ContentReqDTO;
import com.zw.cn.service.authConfig.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/14 15:03
 * @desc 认证内容配置管理Controller
 */
@Api("认证内容配置管理")
@RestController
@RequestMapping("/bcc/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 保存认证内容
     * @param contentReqDTO 保存内容
     * @return 是否保存成功 true 成功  false 失败
     */
    @ApiOperation(value = "保存认证内容")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "保存认证内容")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Boolean> saveContent(@RequestBody @Valid ContentReqDTO contentReqDTO) {
        return BaseResult.createWebSuccessResult(contentService.saveContent(contentReqDTO));
    }

    /**
     * 认证内容列表查询
     * @param contentReqDTO 查询参数
     * @return 认证内容列表
     */
    @ApiOperation(value = "认证内容列表查询")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "认证内容列表查询")
    @PostMapping(value = "/queryList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageQueryResponse<Map> queryContentList(@RequestBody PageQueryRequest<ContentReqDTO> contentReqDTO) {
        return contentService.queryContentList(contentReqDTO);
    }

    /**
     * 根据id查询认证内容信息
     * @param id 查询参数
     * @return 认证内容信息
     */
    @ApiOperation(value = "根据id查询认证内容信息")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "根据id查询认证内容信息")
    @GetMapping(value = "/queryById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Map> queryById(@PathVariable Long id) {
        return BaseResult.createWebSuccessResult(contentService.queryById(id));
    }

    /**
     * 根据id更新认证内容信息
     * @param contentReqDTO 入参
     * @return 认证内容信息
     */
    @ApiOperation(value = "根据id更新认证内容信息")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "根据id更新认证内容信息")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Boolean> update(@RequestBody ContentReqDTO contentReqDTO) {
        return BaseResult.createWebSuccessResult(contentService.update(contentReqDTO));
    }

}