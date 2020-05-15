package com.zw.cn.user.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/8/13
 * Time: 9:28
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@Data
public class UserLoginResp implements Serializable {

    /**
     * 用户uid
     */
    private Integer uid;
    /**
     * 用户头像地址
     */
    private String avatar;
    /**
     * 用户手机号
     */
    private String mobile;
    /**
     * 用户登录token
     */
    private String token;

}
