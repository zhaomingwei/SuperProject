package com.zw.cn.request.authBus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zw.cn.entity.authBus.authApplyForm.AuthApplyForm;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 赵威
 * @date 2021/4/28 17:13
 * @desc 业务认证请求类
 */
@Data
public class AuthBusReqDTO extends AuthApplyForm {

    /**
     * 查询条件：客商名称或者编码
     */
    private String authPersonKeywords;

    /**
     * 查询条件：法人名称或者手机号
     */
    private String legalPersonKeywords;

    /**
     * 查询条件：创建开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeStart;

    /**
     * 查询条件：创建结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeEnd;

    /**
     * 查询条件：审核开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTimeStart;

    /**
     * 查询条件：审核结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTimeEnd;

    /**
     * 认证所填写内容,如：姓名,身份证号等，比如个人货主快速认证：{“realName”: “王小二”,“idCardNo”：“xxx”}
     */
    private Map fillContent;

    /**
     * 认证内容
     */
    private List<AuthContentReqDTO> authContentReqDTOList;

}
