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
 * 认证业务列表管理
 * @author 赵威
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusResponse implements Serializable {

    /**
     * id
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
     * 对应页面上所填写信息列表-对应数据库字段多个信息输入控件json串
     */
    private List<InputsInfoReqDTO> inputsInfoReqDTOS;

    /**
     * 对应页面上所需认证材料清单-对应数据库字段:material_ids(认证材料清单ID串用,连接)
     */
    private List<Long> materialIds;

    /**
     * 认证通过后可参与业务
     */
    private List<String> canUseItemValues;

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