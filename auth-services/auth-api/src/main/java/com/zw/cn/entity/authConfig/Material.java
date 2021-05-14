package com.zw.cn.entity.authConfig;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 认证材料实体
 * @author 赵威
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 材料名称
     */
    private String name;

    /**
     * 认证内容ID串用,连接,默认值为空字符串，在更新时如果没有输入控件则更新把数据库字段更新为空字符串
     */
    @Builder.Default
    private String contentIds = "";

    /**
     * 内容列表
     */
    @JsonIgnore
    private List<Content> contentList;

    /**
     * 多个信息输入控件json串,默认值为空字符串，在更新时如果没有输入控件则更新把数据库字段更新为空字符串
     */
    @Builder.Default
    private String inputsInfoStr = "";

    /**
     * 内容备注
     */
    private String remark;

    /**
     * 状态(是否有效,0-无效,1-有效)
     */
    private Integer valid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

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

    private static final long serialVersionUID = 1L;
}