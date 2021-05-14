package com.zw.cn.cache;

import com.zw.cn.common.util.SpringUtils;
import com.zw.cn.entity.dict.Dict;
import com.zw.cn.mapper.dict.DictMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 赵威
 * @date 2021/4/29 10:05
 * @desc 项目启动时将字典表字段加载进内存缓存
 */
@Slf4j
public class DictCache {

    private static DictMapper dictMapper;

    public static Map<String, List<Dict>> dictCache = new HashMap<>();

    static {
        //注意此处不能使用依赖注入，因为此时dictionariesRepository还没创建出来，可以获取上下文手动创建
        dictMapper = SpringUtils.getBean(DictMapper.class);
        toData();
    }

    public static void toData() {
        List<Dict> all = dictMapper.findAll();
        dictCache = all.stream().collect(Collectors.groupingBy(Dict::getDictCode));
        if(log.isInfoEnabled()){
            log.info("dict字典表缓存：[{}]", dictCache);
        }
    }

    /** 返回list数据格式 **/
    public static List<Dict> toDataList(String findType){
        List<Dict> dictList = dictCache.get(findType);
        if(CollectionUtils.isEmpty(dictList)){
            return Collections.EMPTY_LIST;
        }
        return dictCache.get(findType);
    }

    /**
     * 验证传入的target 是否存在
     * @param type 类型
     * @param target 需要验证的值
     * @return true 存在 false 不存在
     */
    public static boolean exist(String type, String target){
        List<Dict> dictList = dictCache.get(type);
        if (CollectionUtils.isEmpty(dictList)){
            return false;
        }
        return dictList.stream().filter(m->m.getItemValue().equals(target)).findAny().isPresent();
    }

}
