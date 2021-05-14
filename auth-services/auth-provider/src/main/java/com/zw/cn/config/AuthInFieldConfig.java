package com.zw.cn.config;

/**
 * @author 赵威
 * @date 2021/4/30 13:58
 * @desc TODO
 */
public class AuthInFieldConfig {

    /**
     * 查询认证内容列表返回字段
     **/
    public static final String[] AuthContentList_InFields = {"id", "name", "type", "remark", "tagCode", "updateUserName", "updateTime"};

    /**
     * 查询认证内容详情返回字段
     **/
    public static final String[] AuthContentDetail_InFields = {"id", "name", "type", "remark", "tagCode"};

    /**
     * 查询认证材料列表返回字段
     **/
    public static final String[] AuthMaterialList_InFields = {"id", "name", "remark", "updateUserName", "updateTime"};

    /**
     * 查询认证材料详情返回字段
     **/
    public static final String[] AuthMaterialDetail_InFields = {"id", "name", "contentIds", "remark", "inputsInfoReqDTOS", "updateUserName", "updateTime"};

    /**
     * 查询认证业务列表返回字段
     **/
    public static final String[] AuthBusList_InFields = {"id", "busCode", "name", "type", "remark", "updateUserName", "updateTime"};

    /**
     * 查询认证业务详情返回字段
     **/
    public static final String[] AuthBusDetail_InFields = {"id", "busCode", "name", "type", "inputsInfoReqDTOS", "materialIds", "canUseItemValues", "remark"};


    /**
     * 业务认证接口返回字段
     **/
    public static final String[] AuthResultResponse_InFields = {"applyNo", "applyStatus"};

    /**
     * 认证申请单列表查询返回字段
     **/
    public static final String[] AuthApplyList_InFields = {"applyNo", "applyStatus", "authSource", "authPersonName", "authPersonCode", "authLegalPersonName", "authLegalPersonPhone",
            "merchantBusType", "merchantBusSubType", "createTime", "auditTime", "auditPerson", "auditSug"};

    /**
     * 认证申请单详情查询返回字段
     **/
    public static final String[] AuthApplyDetail_InFields = {"applyNo", "applyStatus", "authFillContent", "auditSug"};

    /**
     * 认证申请单查询认证内容返回字段
     **/
    public static final String[] AuthApplyDetailContent_InFields = {"authContentCode", "authFileLink"};

}
