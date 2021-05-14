package com.zw.cn.mapper.dict;

import com.zw.cn.entity.dict.Dict;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author 赵威
 * @date 2021/4/14 11:34
 * @desc 字典项查询Mapper
 */
@Repository
public interface DictMapper {

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
    List<Dict> queryItemByItemValue(List<String> list);

    /**
     * 查询所有有效的字典项
     * @return 所有有效的字典项
     */
    List<Dict> findAll();

}
