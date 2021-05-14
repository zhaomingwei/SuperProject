package com.zw.cn.service.impl.finishAuthContent.impl;

import com.zw.cn.core.service.impl.BaseServiceImpl;
import com.zw.cn.entity.authBus.finishAuthContent.FinishAuthContent;
import com.zw.cn.entity.authBus.finishAuthContent.FinishAuthContentExample;
import com.zw.cn.mapper.authBus.finishAuthContent.FinishAuthContentMapper;
import com.zw.cn.mapper.authBus.finishAuthContent.extension.FinishAuthContentExtMapper;
import com.zw.cn.service.finishAuthContent.FinishAuthContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinishAuthContentServiceImpl extends BaseServiceImpl<FinishAuthContent, FinishAuthContentExample, Integer> implements FinishAuthContentService {

    @Autowired
    public FinishAuthContentMapper finishAuthContentMapper;

    @Autowired
    public FinishAuthContentExtMapper finishAuthContentExtMapper;

    @Autowired
    public void setMapper() {
        super.setMapper(finishAuthContentMapper);
    }

    @Override
    public void batchInsert(List<FinishAuthContent> list) {
        finishAuthContentExtMapper.batchInsert(list);
    }
}