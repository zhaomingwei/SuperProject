package com.zw.cn.service.dict;

import com.zw.cn.entity.dict.Dict;

import java.util.List;

/**
 * @author 赵威
 * @date 2021/4/15 14:55
 * @desc 字典项查询service
 */
public interface DictService {

    /**
     * 根据字典code查询字典项列表
     * @param dictCode 字典code查询参数
     * @return 字典项列表
     */
    List<Dict> queryItemByCode(String dictCode);

    /**
     * 根据字典code查询字典项列表
     * @param list 字典项值查询参数列表
     * @return 字典项列表
     */
    List<Dict> queryItemListByItemValue(List<String> list);

    /**
     * @param pwd 重新加载缓存,密码固定为:bccReloadDC
     */
    void reloadDictCache(String pwd);

}
