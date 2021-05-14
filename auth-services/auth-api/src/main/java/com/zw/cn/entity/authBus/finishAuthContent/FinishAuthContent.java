package com.zw.cn.entity.authBus.finishAuthContent;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户已完成的认证材料管理表<p/>
 * t_bcc_finish_auth_content<p/>
 * @date Thu Apr 29 09:35:59 CST 2021
 *
 */
@Builder
public class FinishAuthContent implements Serializable {
    /**
     * 主键
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private Integer id;

    /**
     * 认证用户userId(接口传入,标识哪一个用户)
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String userId;

    /**
     * 认证申请单号(关联t_bcc_auth_apply_form表的apply_no字段)
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String applyNo;

    /**
     * 认证内容编码(关联t_bcc_content表的tag_code字段)
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String authContentCode;

    /**
     * 认证文件链接
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String authFileLink;

    /**
     * 内容备注
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String remark;

    /**
     * 有效期(到该时间后认证过期)
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private Date indate;

    /**
     * 状态(是否有效,0-无效,1-有效)
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private Boolean valid;

    /**
     * 创建时间
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private Date createTime;

    /**
     * 更新时间
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private Date updateTime;

    /**
     * 创建人名称
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String createUserName;

    /**
     * 创建人用户代码
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String createUserCode;

    /**
     * 更新人名称
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String updateUserName;

    /**
     * 更新人用户代码
     * @author ZhaoWei
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    private String updateUserCode;

    /**
     * @return finishAuthContent : 主键
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
     * @return finishAuthContent : 认证用户userId(接口传入,标识哪一个用户)
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
     * @return finishAuthContent : 认证申请单号(关联t_bcc_auth_apply_form表的apply_no字段)
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * @param applyNo : 认证申请单号(关联t_bcc_auth_apply_form表的apply_no字段)
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    /**
     * @return finishAuthContent : 认证内容编码(关联t_bcc_content表的tag_code字段)
     */
    public String getAuthContentCode() {
        return authContentCode;
    }

    /**
     * @param authContentCode : 认证内容编码(关联t_bcc_content表的tag_code字段)
     */
    public void setAuthContentCode(String authContentCode) {
        this.authContentCode = authContentCode;
    }

    /**
     * @return finishAuthContent : 认证文件链接
     */
    public String getAuthFileLink() {
        return authFileLink;
    }

    /**
     * @param authFileLink : 认证文件链接
     */
    public void setAuthFileLink(String authFileLink) {
        this.authFileLink = authFileLink;
    }

    /**
     * @return finishAuthContent : 内容备注
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
     * @return finishAuthContent : 有效期(到该时间后认证过期)
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
     * @return finishAuthContent : 状态(是否有效,0-无效,1-有效)
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
     * @return finishAuthContent : 创建时间
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
     * @return finishAuthContent : 更新时间
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
     * @return finishAuthContent : 创建人名称
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
     * @return finishAuthContent : 创建人用户代码
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
     * @return finishAuthContent : 更新人名称
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
     * @return finishAuthContent : 更新人用户代码
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
        sb.append(", authContentCode=").append(authContentCode);
        sb.append(", authFileLink=").append(authFileLink);
        sb.append(", remark=").append(remark);
        sb.append(", indate=").append(indate);
        sb.append(", valid=").append(valid);
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