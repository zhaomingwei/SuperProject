package com.zw.cn.request.authConfig;

import com.zw.cn.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 认证业务列表管理请求实体类
 * @author 赵威
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusReqDTO extends BaseEntity implements Serializable {

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

}