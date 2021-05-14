package com.zw.cn.mapper.authBus.finishAuthContent.extension;

import com.zw.cn.entity.authBus.finishAuthContent.FinishAuthContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinishAuthContentExtMapper {

    void batchInsert(List<FinishAuthContent> list);

}