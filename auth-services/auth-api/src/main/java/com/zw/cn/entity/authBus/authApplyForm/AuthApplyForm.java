package com.zw.cn.entity.authBus.authApplyForm;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户认证申请单管理表<p/>
 * t_bcc_auth_apply_form<p/>
 * @date Thu Apr 29 16:48:04 CST 2021
 *
 */
@SuppressWarnings("serial")
public class AuthApplyForm implements Serializable {
    /**
     * 主键
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private Integer id;

    /**
     * 认证用户userId(接口传入,标识哪一个用户)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String userId;

    /**
     * 认证申请单号(关联t_bcc_finish_auth_content表的apply_no字段,认证内容)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String applyNo;

    /**
     * 认证业务编码(关联t_bcc_bus表的bus_code字段)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String busCode;

    /**
     * 认证申请单状态(关联t_bcc_dict_item表的item_value字段里的applyStatus)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String applyStatus;

    /**
     * 审核方式(关联t_bcc_dict_item表的item_value字段里的auditType)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String auditType;

    /**
     * 审核人
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String auditPerson;

    /**
     * 审核时间
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private Date auditTime;

    /**
     * 审核意见
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String auditSug;

    /**
     * 认证发起端(关联t_bcc_dict_item表的item_value字段里的authSource)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String authSource;

    /**
     * 认证发起人类型(关联t_bcc_dict_item表的item_value字段里的authPersonType)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String authPersonType;

    /**
     * 认证发起人编码(客商编码或者平台运营编码)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String authPersonCode;

    /**
     * 认证发起人名称(客商名称或者平台运营姓名)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String authPersonName;

    /**
     * 法人姓名(个人客商该指个人姓名)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String authLegalPersonName;

    /**
     * 法人手机号(个人客商该指个人手机号)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String authLegalPersonPhone;

    /**
     * 认证类型(关联t_bcc_dict_item表的item_value字段里的authType)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String authType;

    /**
     * 客商业务类型(关联t_bcc_dict_item表的item_value字段里的merchantBusType)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String merchantBusType;

    /**
     * 客商业务子类型(关联t_bcc_dict_item表的item_value字段里的merchantBusSubType)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String merchantBusSubType;

    /**
     * 认证所填写内容(json串),如：姓名,身份证号等，比如个人货主快速认证：{“realName”: “王小二”,“idCardNo”：“xxx”}
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String authFillContent;

    /**
     * 内容备注
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String remark;

    /**
     * 状态(是否有效,0-无效,1-有效)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private Boolean valid;

    /**
     * 有效期(到该时间后认证过期)
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private Date indate;

    /**
     * 创建时间
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private Date createTime;

    /**
     * 更新时间
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private Date updateTime;

    /**
     * 创建人名称
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String createUserName;

    /**
     * 创建人用户代码
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String createUserCode;

    /**
     * 更新人名称
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String updateUserName;

    /**
     * 更新人用户代码
     * @author ZhaoWei
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    private String updateUserCode;

    /**
     * @return authApplyForm : 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id : 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return authApplyForm : 认证用户userId(接口传入,标识哪一个用户)
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId : 认证用户userId(接口传入,标识哪一个用户)
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return authApplyForm : 认证申请单号(关联t_bcc_finish_auth_content表的apply_no字段,认证内容)
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * @param applyNo : 认证申请单号(关联t_bcc_finish_auth_content表的apply_no字段,认证内容)
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    /**
     * @return authApplyForm : 认证业务编码(关联t_bcc_bus表的bus_code字段)
     */
    public String getBusCode() {
        return busCode;
    }

    /**
     * @param busCode : 认证业务编码(关联t_bcc_bus表的bus_code字段)
     */
    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    /**
     * @return authApplyForm : 认证申请单状态(关联t_bcc_dict_item表的item_value字段里的applyStatus)
     */
    public String getApplyStatus() {
        return applyStatus;
    }

    /**
     * @param applyStatus : 认证申请单状态(关联t_bcc_dict_item表的item_value字段里的applyStatus)
     */
    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    /**
     * @return authApplyForm : 审核方式(关联t_bcc_dict_item表的item_value字段里的auditType)
     */
    public String getAuditType() {
        return auditType;
    }

    /**
     * @param auditType : 审核方式(关联t_bcc_dict_item表的item_value字段里的auditType)
     */
    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    /**
     * @return authApplyForm : 审核人
     */
    public String getAuditPerson() {
        return auditPerson;
    }

    /**
     * @param auditPerson : 审核人
     */
    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson;
    }

    /**
     * @return authApplyForm : 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * @param auditTime : 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * @return authApplyForm : 审核意见
     */
    public String getAuditSug() {
        return auditSug;
    }

    /**
     * @param auditSug : 审核意见
     */
    public void setAuditSug(String auditSug) {
        this.auditSug = auditSug;
    }

    /**
     * @return authApplyForm : 认证发起端(关联t_bcc_dict_item表的item_value字段里的authSource)
     */
    public String getAuthSource() {
        return authSource;
    }

    /**
     * @param authSource : 认证发起端(关联t_bcc_dict_item表的item_value字段里的authSource)
     */
    public void setAuthSource(String authSource) {
        this.authSource = authSource;
    }

    /**
     * @return authApplyForm : 认证发起人类型(关联t_bcc_dict_item表的item_value字段里的authPersonType)
     */
    public String getAuthPersonType() {
        return authPersonType;
    }

    /**
     * @param authPersonType : 认证发起人类型(关联t_bcc_dict_item表的item_value字段里的authPersonType)
     */
    public void setAuthPersonType(String authPersonType) {
        this.authPersonType = authPersonType;
    }

    /**
     * @return authApplyForm : 认证发起人编码(客商编码或者平台运营编码)
     */
    public String getAuthPersonCode() {
        return authPersonCode;
    }

    /**
     * @param authPersonCode : 认证发起人编码(客商编码或者平台运营编码)
     */
    public void setAuthPersonCode(String authPersonCode) {
        this.authPersonCode = authPersonCode;
    }

    /**
     * @return authApplyForm : 认证发起人名称(客商名称或者平台运营姓名)
     */
    public String getAuthPersonName() {
        return authPersonName;
    }

    /**
     * @param authPersonName : 认证发起人名称(客商名称或者平台运营姓名)
     */
    public void setAuthPersonName(String authPersonName) {
        this.authPersonName = authPersonName;
    }

    /**
     * @return authApplyForm : 法人姓名(个人客商该指个人姓名)
     */
    public String getAuthLegalPersonName() {
        return authLegalPersonName;
    }

    /**
     * @param authLegalPersonName : 法人姓名(个人客商该指个人姓名)
     */
    public void setAuthLegalPersonName(String authLegalPersonName) {
        this.authLegalPersonName = authLegalPersonName;
    }

    /**
     * @return authApplyForm : 法人手机号(个人客商该指个人手机号)
     */
    public String getAuthLegalPersonPhone() {
        return authLegalPersonPhone;
    }

    /**
     * @param authLegalPersonPhone : 法人手机号(个人客商该指个人手机号)
     */
    public void setAuthLegalPersonPhone(String authLegalPersonPhone) {
        this.authLegalPersonPhone = authLegalPersonPhone;
    }

    /**
     * @return authApplyForm : 认证类型(关联t_bcc_dict_item表的item_value字段里的authType)
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * @param authType : 认证类型(关联t_bcc_dict_item表的item_value字段里的authType)
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    /**
     * @return authApplyForm : 客商业务类型(关联t_bcc_dict_item表的item_value字段里的merchantBusType)
     */
    public String getMerchantBusType() {
        return merchantBusType;
    }

    /**
     * @param merchantBusType : 客商业务类型(关联t_bcc_dict_item表的item_value字段里的merchantBusType)
     */
    public void setMerchantBusType(String merchantBusType) {
        this.merchantBusType = merchantBusType;
    }

    /**
     * @return authApplyForm : 客商业务子类型(关联t_bcc_dict_item表的item_value字段里的merchantBusSubType)
     */
    public String getMerchantBusSubType() {
        return merchantBusSubType;
    }

    /**
     * @param merchantBusSubType : 客商业务子类型(关联t_bcc_dict_item表的item_value字段里的merchantBusSubType)
     */
    public void setMerchantBusSubType(String merchantBusSubType) {
        this.merchantBusSubType = merchantBusSubType;
    }

    /**
     * @return authApplyForm : 认证所填写内容(json串)
     */
    public String getAuthFillContent() {
        return authFillContent;
    }

    /**
     * @param authFillContent : 认证所填写内容(json串)
     */
    public void setAuthFillContent(String authFillContent) {
        this.authFillContent = authFillContent;
    }

    /**
     * @return authApplyForm : 内容备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark : 内容备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return authApplyForm : 状态(是否有效,0-无效,1-有效)
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * @param valid : 状态(是否有效,0-无效,1-有效)
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * @return authApplyForm : 有效期(到该时间后认证过期)
     */
    public Date getIndate() {
        return indate;
    }

    /**
     * @param indate : 有效期(到该时间后认证过期)
     */
    public void setIndate(Date indate) {
        this.indate = indate;
    }

    /**
     * @return authApplyForm : 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime : 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return authApplyForm : 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime : 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return authApplyForm : 创建人名称
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * @param createUserName : 创建人名称
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    /**
     * @return authApplyForm : 创建人用户代码
     */
    public String getCreateUserCode() {
        return createUserCode;
    }

    /**
     * @param createUserCode : 创建人用户代码
     */
    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    /**
     * @return authApplyForm : 更新人名称
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * @param updateUserName : 更新人名称
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * @return authApplyForm : 更新人用户代码
     */
    public String getUpdateUserCode() {
        return updateUserCode;
    }

    /**
     * @param updateUserCode : 更新人用户代码
     */
    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", applyNo=").append(applyNo);
        sb.append(", busCode=").append(busCode);
        sb.append(", applyStatus=").append(applyStatus);
        sb.append(", auditType=").append(auditType);
        sb.append(", auditPerson=").append(auditPerson);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", auditSug=").append(auditSug);
        sb.append(", authSource=").append(authSource);
        sb.append(", authPersonType=").append(authPersonType);
        sb.append(", authPersonCode=").append(authPersonCode);
        sb.append(", authPersonName=").append(authPersonName);
        sb.append(", authLegalPersonName=").append(authLegalPersonName);
        sb.append(", authLegalPersonPhone=").append(authLegalPersonPhone);
        sb.append(", authType=").append(authType);
        sb.append(", merchantBusType=").append(merchantBusType);
        sb.append(", merchantBusSubType=").append(merchantBusSubType);
        sb.append(", authFillContent=").append(authFillContent);
        sb.append(", remark=").append(remark);
        sb.append(", valid=").append(valid);
        sb.append(", indate=").append(indate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", createUserCode=").append(createUserCode);
        sb.append(", updateUserName=").append(updateUserName);
        sb.append(", updateUserCode=").append(updateUserCode);
        sb.append("]");
        return sb.toString();
    }
}