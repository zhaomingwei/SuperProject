package com.zw.cn.response.authConfig;

import com.zw.cn.request.authConfig.InputsInfoReqDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 认证材料清单管理
 * @author 赵威
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialResponse implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 材料名称
     */
    private String name;

    /**
     * 认证内容ID列表
     */
    private List<Long> contentIds;

    /**
     * 信息输入控件列表
     */
    private List<InputsInfoReqDTO> inputsInfoReqDTOS;

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

}