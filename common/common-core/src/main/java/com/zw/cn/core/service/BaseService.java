package com.zw.cn.core.service;

import com.zw.cn.core.model.BaseExample;
import com.zw.cn.core.model.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 赵威
 * @date 2021/4/26 14:01
 * @desc TODO
 */
public interface BaseService<T, Example extends BaseExample, ID> {
    long countByExample(Example var1);

    int deleteByExample(Example var1);

    int deleteByPrimaryKey(ID var1);

    int insert(T var1);

    int insertSelective(T var1);

    List<T> selectByExample(Example var1);

    T selectByCondition(Example var1);

    List<T> selectByPageExample(Example var1, PageInfo var2);

    T selectByPrimaryKey(ID var1);

    int updateByExampleSelective(@Param("record") T var1, @Param("example") Example var2);

    int updateByExample(@Param("record") T var1, @Param("example") Example var2);

    int updateByPrimaryKeySelective(T var1);

    int updateByPrimaryKey(T var1);
}