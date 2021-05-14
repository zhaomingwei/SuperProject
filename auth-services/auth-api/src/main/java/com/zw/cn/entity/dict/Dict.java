package com.zw.cn.entity.dict;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 赵威
 * @date 2021/4/15 14:51
 * @desc 字典项
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dict {

    /**
     * 字典code
     */
    private String dictCode;

    /**
     * 字典项文本
     */
    private String itemText;

    /**
     * 字典项值
     */
    private String itemValue;

    /**
     * 排序
     */
    private String sortOrder;

}
