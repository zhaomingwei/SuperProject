package com.zw.cn.request.authBus;

import lombok.Data;

/**
 * @author 赵威
 * @date 2021/4/26 17:47
 * @desc TODO
 */
@Data
public class QueryNeedAuthReqDTO {

    /**
     * 认证业务code(全局唯一,关联t_bcc_content表的tag_code字段)
     */
    private String busCode;

    /**
     * 用户唯一标识,如果不为空查询之前认证过什么内容,否则查询该认证业务下配置的所有认证项
     */
    private String userId;

}
