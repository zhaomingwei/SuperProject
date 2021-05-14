package com.zw.cn.request.authConfig;

import com.zw.cn.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 认证材料清单管理请求实体类
 * @author 赵威
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialReqDTO extends BaseEntity implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 所用于业务ID
     */
    private Long busId;

    /**
     * 材料名称
     */
    private String name;

    /**
     * 对应页面上所上传内容-对应数据库字段认证内容ID串用,分割
     */
    private List<Long> contentIds;

    /**
     * 材料id列表
     */
    private List<Long> materialIds;

    /**
     * 对应页面上所填写信息列表-对应数据库字段多个信息输入控件json串
     */
    private List<InputsInfoReqDTO> inputsInfoReqDTOS;

    /**
     * 内容备注
     */
    private String remark;

}