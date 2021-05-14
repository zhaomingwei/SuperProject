package com.zw.cn.service.impl.dict.impl;

import com.zw.cn.cache.DictCache;
import com.zw.cn.common.AssertUtils;
import com.zw.cn.common.enums.AuthConfigEnum;
import com.zw.cn.entity.dict.Dict;
import com.zw.cn.exception.ServiceException;
import com.zw.cn.mapper.dict.DictMapper;
import com.zw.cn.service.dict.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 赵威
 * @date 2021/4/15 14:59
 * @desc 字典项查询service实现类
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    /**
     * 根据字典code查询字典项列表
     * @param dictCode 字典code查询参数
     * @return 字典项列表
     */
    @Override
    public List<Dict> queryItemByCode(String dictCode) {
        if (StringUtils.isEmpty(dictCode)){
            throw new ServiceException(AuthConfigEnum.PARAM_IS_NOT_NULL);
        }
        return dictMapper.queryItemByCode(dictCode);
    }

    /**
     * 根据字典code列表查询字典项列表
     * @param list 字典项值查询参数
     * @return 字典项列表
     */
    @Override
    public List<Dict> queryItemListByItemValue(List<String> list){
        if (CollectionUtils.isEmpty(list)){
            throw new ServiceException(AuthConfigEnum.PARAM_IS_NOT_NULL);
        }
        return dictMapper.queryItemByItemValue(list);
    }

    /**
     * @param pwd 重新加载缓存,密码固定为:bccReloadDC
     */
    @Override
    public void reloadDictCache(String pwd) {
        AssertUtils.ifTrue(()->{
            DictCache.toData();
            return null;
        }, StringUtils.hasLength(pwd) && "bccReloadDC".equals(pwd));
    }

}
