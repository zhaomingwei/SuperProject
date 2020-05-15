package com.zw.cn.user.inter;

import com.zw.cn.response.Response;
import com.zw.cn.user.request.CheckAuthReq;
import com.zw.cn.user.request.UserLoginReq;
import com.zw.cn.user.request.UserRegisterReq;
import com.zw.cn.user.response.CheckAuthResp;
import com.zw.cn.user.response.UserLoginResp;
import com.zw.cn.user.response.UserRegisterResp;


/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2019/8/13
 * Time: 9:21
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public interface IUserCoreService {

    /**
     * 用户登录
     * @param request
     * @return
     */
    Response<UserLoginResp> login(UserLoginReq request);

    /**
     * 校验过程
     * @param request
     * @return
     */
    Response<CheckAuthResp> validToken(CheckAuthReq request);

    /**
     * 注册
     */
    Response<UserRegisterResp> register(UserRegisterReq userRegisterReq);

}
