package com.zw.cn.request.authBus;

import lombok.Data;

/**
 * @author 赵威
 * @date 2021/4/28 19:34
 * @desc 业务认证内容
 */
@Data
public class AuthContentReqDTO {

    /**
     * 认证内容编码,对应表t_bcc_content的tag_code字段
     */
    private String authContentCode;

    /**
     * 认证内容文件链接
     */
    private String authFileLink;

}
