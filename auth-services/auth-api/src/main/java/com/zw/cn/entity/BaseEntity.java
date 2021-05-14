package com.zw.cn.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 赵威
 * @date 2021/4/14 11:54
 * @desc TODO
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否有效：1 有效，0 无效
     */
    private Integer valid;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 创建人用户代码
     */
    private String createUserCode;

    /**
     * 更新人名称
     */
    private String updateUserName;

    /**
     * 更新人用户代码
     */
    private String updateUserCode;

}