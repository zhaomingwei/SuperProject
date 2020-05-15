/*
package com.zw.cn.user.controller;

import com.zw.cn.common.Constant;
import com.zw.cn.response.Response;
import com.zw.cn.user.inter.IUserCoreService;
import com.zw.cn.user.request.UserLoginReq;
import com.zw.cn.user.response.UserLoginResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2020/5/15
 * Time: 8:52
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 *//*

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    */
/**
     * 注入service
     *//*

    @Autowired
    private IUserCoreService userLoginService;

    */
/**
     * 用户登录
     * @return
     *//*

    @RequestMapping("login")
    public Response userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password){
        log.info("[user-controller]模块用户登录接口:userLogin,请求参数userName:{},password:{}", userName , password);
        Response<UserLoginResp> response = new Response();
        UserLoginReq req = new UserLoginReq();
        if(StringUtils.isEmpty(userName)){
            response.setCode(Constant.USERNAME_NOT_EMPTY_CODE);
            response.setDesc(Constant.USERNAME_NOT_EMPTY_DESC);
            return response;
        }
        if(StringUtils.isEmpty(password)){
            response.setCode(Constant.USERPWD_NOT_EMPTY_CODE);
            response.setDesc(Constant.USERPWD_NOT_EMPTY_DESC);
            return response;
        }
        req.setUserName(userName);
        req.setPassword(password);
        try {
            log.info("[user-services]模块用户登录接口:userLoginService.login,接口请求参数userName:{},req:{}", userName, req);
            response = userLoginService.login(req);
            log.info("[user-services]模块用户登录接口:userLoginService.login接口,响应参数userName:{},response:{}", userName, response);
        }catch (Exception e){
            log.error("[user-services]模块用户登录接口异常:{}", e);

        }

    }

}
*/
