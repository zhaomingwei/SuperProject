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
 * @desc 认证业务实体
 * @author 赵威
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bus implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 认证业务编码
     */
    private String busCode;

    /**
     * 认证业务名称
     */
    private String name;

    /**
     * 认证业务类型
     */
    private String type;

    /**
     * 认证材料清单ID串用,连接，在更新时如果没有输入控件则更新把数据库字段更新为空字符串
     */
    @Builder.Default
    private String materialIds = "";

    /**
     * 材料列表
     */
    @JsonIgnore
    private List<Material> materialList;

    /**
     * 多个信息输入控件json串，在更新时如果没有输入控件则更新把数据库字段更新为空字符串
     */
    @Builder.Default
    private String inputsInfoStr = "";

    /**
     * 内容备注
     */
    private String remark;

    /**
     * 认证后可参与业务itemValues串用,连接，在更新时如果没有输入控件则更新把数据库字段更新为空字符串
     */
    @Builder.Default
    private String canUseItemValues = "";

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