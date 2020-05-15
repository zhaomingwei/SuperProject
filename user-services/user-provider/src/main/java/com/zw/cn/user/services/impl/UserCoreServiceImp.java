package com.zw.cn.user.services.impl;

import com.zw.cn.response.Response;
import com.zw.cn.user.inter.IUserCoreService;
import com.zw.cn.user.request.CheckAuthReq;
import com.zw.cn.user.request.UserLoginReq;
import com.zw.cn.user.request.UserRegisterReq;
import com.zw.cn.user.response.CheckAuthResp;
import com.zw.cn.user.response.UserLoginResp;
import com.zw.cn.user.response.UserRegisterResp;



/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2020/5/15
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
public class UserCoreServiceImp implements IUserCoreService {
    @Override
    public Response<UserLoginResp> login(UserLoginReq request) {
        return null;
    }

    @Override
    public Response<CheckAuthResp> validToken(CheckAuthReq request) {
        return null;
    }

    @Override
    public Response<UserRegisterResp> register(UserRegisterReq userRegisterReq) {

//        if(!password.equals(password2)){
//            return "两次密码不相同，注册失败！！";
//        }else {
//            int res = userLoginService.addUser(username,password,age);
//            if(res == 0){
//                return "注册失败！";
//            }else {
//                return "注册成功！";
//            }
//        }
        return null;
    }
}
