package com.zw.cn.user;

import com.sun.deploy.util.StringUtils;
import com.zw.cn.user.request.UserLoginReq;

import java.util.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TreeSet<UserLoginReq> userLoginReqTreeSet = new TreeSet<>((o1, o2) -> {
            if (o1 == o2) {
                return 0;
            }
            // 固定选项排在最前面
            if ("not".equals(o1.getId())) {
                return -1;
            } else if ("not".equals(o2.getId())) {
                return 1;
            }
            return o1.getId().compareTo(o2.getId());
        });
        TreeSet<UserLoginReq> userLoginReqTreeSet1 = new TreeSet<>((o1, o2) -> {
            if (o1 == o2) {
                return 0;
            }
            // 固定选项排在最前面
            if ("not".equals(o1.getId())) {
                return -1;
            } else if ("not".equals(o2.getId())) {
                return 1;
            }
            return o1.getId().compareTo(o2.getId());
        });
        TreeSet<UserLoginReq> userLoginReqTreeSet2 = new TreeSet<>((o1, o2) -> {
            if (o1 == o2) {
                return 0;
            }
            // 固定选项排在最前面
            if ("not".equals(o1.getId())) {
                return -1;
            } else if ("not".equals(o2.getId())) {
                return 1;
            }
            return o1.getId().compareTo(o2.getId());
        });
//        List<UserLoginReq> reqs = new ArrayList<>();
        UserLoginReq u1 = new UserLoginReq();
        u1.setId("1");
        u1.setUserName("u1");
        u1.setPassword("p1");
        UserLoginReq u2 = new UserLoginReq();
        u2.setId("3");//2
        u2.setUserName("u2");
        u2.setPassword("");
        UserLoginReq u3 = new UserLoginReq();
        u3.setId("3");
        u3.setUserName("u3");
        u3.setPassword("p3");
        UserLoginReq u4 = new UserLoginReq();
        u4.setId("4");
        u4.setUserName("u4");
        u4.setPassword("p4");
        UserLoginReq u5 = new UserLoginReq();
        u5.setId("4");
        u5.setUserName("u5");
        u5.setPassword("p5");
        userLoginReqTreeSet1.add(u1);
        userLoginReqTreeSet1.add(u2);
        userLoginReqTreeSet2.add(u3);
//        reqs.add(u5);
//        reqs.add(u4);
//        userLoginReqTreeSet2.add(u4);
//        userLoginReqTreeSet2.add(u5);

        userLoginReqTreeSet.addAll(userLoginReqTreeSet1);
        userLoginReqTreeSet.addAll(userLoginReqTreeSet2);
//        userLoginReqTreeSet.addAll(userLoginReqTreeSet2);
//        TreeSet<UserLoginReq> userLoginReqs = userLoginReqTreeSet.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserLoginReq::getId))), TreeSet::new));

        for (UserLoginReq u : userLoginReqTreeSet){
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        }

        System.out.println("-------------------");

        TreeSet<UserLoginReq> resultDtoList = new TreeSet<>((o1, o2) -> {
            if (o1 == o2) {
                return 0;
            }
            // 固定选项排在最前面
            if (o1.getId().equals(o2.getId())) {
                return -1;
            } else {
                return 1;
            }
        });
        Map<String, UserLoginReq> map = new HashMap();
        UserLoginReq c = null;
        for (UserLoginReq cityResultDTO : userLoginReqTreeSet){
            // 不包含, 加入map
//            if (!map.containsKey(cityResultDTO.getId())){
//                map.put(cityResultDTO.getId(), cityResultDTO);
//            } else { // 包含   说明 这个 cityCode 在 resCityResultDto 出现超过1次 即重复；由于 伯乐返回的城市属性比中央多，所以就保留有更多属性的元素，剔除中央
//                c = map.get(cityResultDTO.getId());
//                if (!StringUtils(c.getPassword())){ // 代表 伯乐路线
//                    c.setAge(1234);
//                } else {
//                    c.setAge(1234);
//                    map.put(cityResultDTO.getId(), cityResultDTO); // 覆盖之前的元素
//                }
//            }
        }
        for (UserLoginReq cityResultDTO : map.values()){
            resultDtoList.add(cityResultDTO);
        }

        for (UserLoginReq u : resultDtoList){
            System.out.println(u.getId());
            System.out.println(u.getUserName());
            System.out.println(u.getPassword());
        }

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(StringUtils.join(list, ","));
    }

}
