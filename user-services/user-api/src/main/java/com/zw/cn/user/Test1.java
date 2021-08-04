package com.zw.cn.user;

import com.zw.cn.user.request.UserLoginReq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 赵威
 * @date 2021/6/18 13:53
 * @desc TODO
 */
public class Test1 {

    public static void main(String[] args) {
        UserLoginReq req1= new UserLoginReq();
        req1.setUserName("1");
        List<UserLoginReq> list1 = new ArrayList();
        list1.add(req1);

        UserLoginReq req2= new UserLoginReq();
        req2.setUserName("2");
        UserLoginReq req3= new UserLoginReq();
        req3.setUserName("1");
        List<UserLoginReq> list2 = new ArrayList();
        list2.add(req2);
        list2.add(req3);

        list1.stream().forEach(s -> list2.stream().anyMatch(s2 -> {
            if (s.getUserName().equals(s2.getUserName())){
                s.setPassword("111");
            }
            return true;
        }));

        System.out.println(list1);

        for (UserLoginReq u1:list1){
            for (UserLoginReq u2:list2){
                if (u1.getUserName().equals(u2.getUserName())){
                    req1.setPassword("111");
                }
            }
        }

        System.out.println(list1);

    }

}
