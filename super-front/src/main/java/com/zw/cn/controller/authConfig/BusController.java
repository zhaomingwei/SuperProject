package com.zw.cn.controller.authConfig;

import com.zw.cn.aspect.MethodLogger;
import com.zw.cn.base.BaseResult;
import com.zw.cn.base.LogTypeEnum;
import com.zw.cn.config.AuthInFieldConfig;
import com.zw.cn.core.result.JsonResult;
import com.zw.cn.page.PageQueryRequest;
import com.zw.cn.page.PageQueryResponse;
import com.zw.cn.request.authConfig.BusReqDTO;
import com.zw.cn.response.authConfig.BusResponse;
import com.zw.cn.service.authConfig.BusService;
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
 * @date 2021/4/21 16:27
 * @desc 认证业务配置管理Controller
 */
@Api("认证业务配置管理")
@RestController
@RequestMapping("/bcc/bus")
public class BusController {

    @Autowired
    private BusService busService;

    /**
     * 保存认证业务
     * @param busReqDTO 认证业务请求
     * @return 是否保存成功 true 成功  false 失败
     */
    @ApiOperation(value = "保存认证业务")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "保存认证业务")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Boolean> saveBus(@RequestBody @Valid BusReqDTO busReqDTO) {
        return BaseResult.createWebSuccessResult(busService.saveBus(busReqDTO));
    }

    /**
     * 认证业务列表查询
     * @param busReqDTO 查询参数
     * @return 认证业务列表
     */
    @ApiOperation(value = "认证业务列表查询")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "认证业务列表查询")
    @PostMapping(value = "/queryList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageQueryResponse<Map> queryBusList(@RequestBody PageQueryRequest<BusReqDTO> busReqDTO) {
        return busService.queryBusList(busReqDTO);
    }

    /**
     * 根据id查询认证业务信息
     * @param id 查询参数
     * @return 认证业务信息
     */
    @ApiOperation(value = "根据id查询认证业务信息")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "根据id查询认证业务信息")
    @GetMapping(value = "/queryById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Map> queryById(@PathVariable Long id) {
        //返回字段抽取
        JsonResult jsonResult = new JsonResult();
        jsonResult.putOnlyBean(busService.queryById(id), AuthInFieldConfig.AuthBusDetail_InFields);
        return BaseResult.createWebSuccessResult((Map) jsonResult.getData());
    }

    /**
     * 根据id更新认证业务信息
     * @param busReqDTO 入参
     * @return 认证业务信息
     */
    @ApiOperation(value = "根据id更新认证业务信息")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "根据id更新认证业务信息")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<Boolean> update(@RequestBody @Valid BusReqDTO busReqDTO) {
        return BaseResult.createWebSuccessResult(busService.update(busReqDTO));
    }

    /**
     * 根据名称模糊查询认证业务列表
     * @param name 入参
     * @return 认证业务信息列表
     */
    @ApiOperation(value = "根据名称模糊查询认证业务列表")
    @MethodLogger(logType = LogTypeEnum.FULL, value = "根据名称模糊查询认证业务列表")
    @GetMapping(value = "/queryListByName/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<List<BusResponse>> queryListByName(@PathVariable String name) {
        return BaseResult.createWebSuccessResult(busService.queryListByName(name));
    }

}