package com.zw.cn.core.service.impl;

import com.zw.cn.core.dao.BaseMapper;
import com.zw.cn.core.model.BaseExample;
import com.zw.cn.core.model.PageInfo;
import com.zw.cn.core.service.BaseService;

import java.util.List;

/**
 * @author 赵威
 * @date 2021/4/26 14:02
 * @desc TODO
 */
public abstract class BaseServiceImpl<T, Example extends BaseExample, ID> implements BaseService<T, Example, ID> {
    private BaseMapper<T, Example, ID> mapper;

    public BaseServiceImpl() {
    }

    public void setMapper(BaseMapper<T, Example, ID> mapper) {
        this.mapper = mapper;
    }

    public long countByExample(Example example) {
        return this.mapper.countByExample(example);
    }

    public int deleteByExample(Example example) {
        return this.mapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(ID id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    public int insert(T record) {
        return this.mapper.insert(record);
    }

    public int insertSelective(T record) {
        return this.mapper.insertSelective(record);
    }

    public List<T> selectByExample(Example example) {
        return this.mapper.selectByExample(example);
    }

    public T selectByCondition(Example example) {
        List<T> datas = this.selectByExample(example);
        return datas != null && datas.size() == 0 ? null : datas.get(0);
    }

    public List<T> selectByPageExample(Example example, PageInfo pageInfo) {
        if (pageInfo != null) {
            example.setPageInfo(pageInfo);
            pageInfo.setPageParams(Long.valueOf(this.countByExample(example)).intValue());
        }

        return this.selectByExample(example);
    }

    public T selectByPrimaryKey(ID id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(T record, Example example) {
        return this.mapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(T record, Example example) {
        return this.mapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(T record) {
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(T record) {
        return this.mapper.updateByPrimaryKey(record);
    }
}

