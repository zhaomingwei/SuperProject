package com.zw.cn.controller.authConfig;

import com.zw.cn.aspect.MethodLogger;
import com.zw.cn.base.BaseResult;
import com.zw.cn.base.LogTypeEnum;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.MaterialReqDTO;
import com.zw.cn.response.authConfig.MaterialResponse;
import com.zw.cn.service.authConfig.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/14 15:03
 * @desc 认证材料配置管理Controller
 */
@Api("认证材料配置管理")
@RestController
@RequestMapping("/bcc/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    /**
     * 保存认证材料
     * @param materialReqDTO 认证材料请求
     * @return 是否保存成功 true 成功  false 失败
     */
    @ApiOperation(value = "保存认证材料")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "保存认证材料")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Boolean> saveMaterial(@RequestBody @Valid MaterialReqDTO materialReqDTO) {
        return BaseResult.createWebSuccessResult(materialService.saveMaterial(materialReqDTO));
    }

    /**
     * 认证材料列表查询
     * @param materialReqDTO 查询参数
     * @return 认证材料列表
     */
    @ApiOperation(value = "认证材料列表查询")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "认证材料列表查询")
    @PostMapping(value = "/queryList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageQueryResponse<Map> queryMaterialList(@RequestBody PageQueryRequest<MaterialReqDTO> materialReqDTO) {
        return materialService.queryMaterialList(materialReqDTO);
    }

    /**
     * 根据id查询认证材料信息
     * @param id 查询参数
     * @return 认证材料信息
     */
    @ApiOperation(value = "根据id查询认证材料信息")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "根据id查询认证材料信息")
    @GetMapping(value = "/queryById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Map> queryById(@PathVariable Long id) {
        return BaseResult.createWebSuccessResult(materialService.queryById(id));
    }

    /**
     * 根据id更新认证材料信息
     * @param materialReqDTO 入参
     * @return 认证材料信息
     */
    @ApiOperation(value = "根据id更新认证材料信息")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "根据id更新认证材料信息")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Boolean> update(@RequestBody @Valid MaterialReqDTO materialReqDTO) {
        return BaseResult.createWebSuccessResult(materialService.update(materialReqDTO));
    }

    /**
     * 根据名称模糊查询认证材料列表
     * @param name 入参
     * @return 认证材料信息列表
     */
    @ApiOperation(value = "根据名称模糊查询认证材料列表")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "根据名称模糊查询认证材料列表")
    @GetMapping(value = "/queryListByName/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<List<MaterialResponse>> queryListByName(@PathVariable String name) {
        return BaseResult.createWebSuccessResult(materialService.queryListByName(name));
    }

}