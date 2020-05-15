/*
package com.zw.cn.user.controller;

import com.zw.cn.user.inter.IUserCoreService;
import com.zw.cn.user.request.UserLoginReq;
import com.zw.cn.user.response.UserLoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

*/
/**
 * Created by ZhaoWei on 2019/8/5/0005.
 *//*

@Controller
@RequestMapping(value = {"/user"})
public class UserLoginController {

    */
/**
     * 注入service
     *//*

    @Autowired
    private IUserCoreService userLoginService;

    */
/**
     * 跳转到用户登录页面
     *
     * @return 登录页面
     *//*

    @RequestMapping(value = {"/login"})
    public String loginHtml() {
        return "userLogin";
    }

    */
/**
     * 跳转到用户注册页面
     *
     * @return 注册页面
     *//*

    @RequestMapping(value = {"/register"})
    public String registerPage() {
        return "register";
    }

    */
/**
     * 获取用户名与密码，用户登录
     *
     * @return 登录成功页面
     *//*

    @RequestMapping(value = {"/userLogin"})
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        UserLoginReq userLoginReq = new UserLoginReq();
        userLoginReq.setUserName(username);
        userLoginReq.setPassword(password);
        try {
            if (StringUtils.isEmpty(username)) {

            }
            if (StringUtils.isEmpty(password)) {

            }
            UserLoginResp response = userLoginService.login(userLoginReq);

        } catch (Exception e) {

        }

        if (response != null) {                                                  //登录成功
            request.getSession().setAttribute("session_user", user);     //将用户信息放入session
            return "index";
        }
        return "loginError";
    }

    */
/**
     * 注册新用户
     *
     * @return 注册结果
     *//*

    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("age") int age) {
        if (!password.equals(password2)) {
            return "两次密码不相同，注册失败！！";
        } else {
            int res = userLoginService.addUser(username, password, age);
            if (res == 0) {
                return "注册失败！";
            } else {
                return "注册成功！";
            }
        }
    }

}
*/
