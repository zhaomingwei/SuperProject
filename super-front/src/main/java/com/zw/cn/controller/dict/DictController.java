package com.zw.cn.controller.dict;

import com.zw.cn.aspect.MethodLogger;
import com.zw.cn.base.BaseResult;
import com.zw.cn.entity.dict.Dict;
import com.zw.cn.service.dict.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 赵威
 * @date 2021/4/14 15:03
 * @desc 字典表Controller
 */
@Api("查询字典信息")
@RestController
@RequestMapping("/bcc/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 根据字典code查询字典项
     * @param dictCode 字典code查询参数
     * @return 字典项
     */
    @ApiOperation(value = "根据字典code查询字典项")
    @GetMapping(value = "/queryItemByCode/{dictCode}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @MethodLogger
    public BaseResult<List<Dict>> queryItemByCode(@PathVariable String dictCode) {
        return BaseResult.createWebSuccessResult(dictService.queryItemByCode(dictCode));
    }

    /**
     * 根据字典code列表查询字典项列表
     * @param list 字典项值查询参数
     * @return 字典项列表
     */
    @ApiOperation(value = "根据字典code查询字典项")
    @PostMapping(value = "/queryItemListByItemValue", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @MethodLogger
    public BaseResult<List<Dict>> queryItemByCode(@RequestBody List<String> list) {
        return BaseResult.createWebSuccessResult(dictService.queryItemListByItemValue(list));
    }

    /**
     * 刷新字典内存缓存
     * @param pwd 密码
     */
    @ApiOperation(value = "刷新字典内存缓存")
    @GetMapping(value = "/reloadCache/{pwd}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @MethodLogger
    public void reloadCache(@PathVariable String pwd) {
        dictService.reloadDictCache(pwd);
    }

}