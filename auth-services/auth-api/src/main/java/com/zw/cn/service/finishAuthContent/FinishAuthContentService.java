package com.zw.cn.service.finishAuthContent;

import com.zw.cn.core.service.BaseService;
import com.zw.cn.entity.authBus.finishAuthContent.FinishAuthContent;
import com.zw.cn.entity.authBus.finishAuthContent.FinishAuthContentExample;

import java.util.List;

public interface FinishAuthContentService extends BaseService<FinishAuthContent, FinishAuthContentExample, Integer> {

    void batchInsert(List<FinishAuthContent> list);

}