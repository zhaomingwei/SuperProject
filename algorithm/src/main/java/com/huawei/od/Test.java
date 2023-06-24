package com.huawei.od;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        //Map map = new HashMap<>();
        Map map = new TreeMap();
        //map.put(null, null);
        map.put("a", 1);
        map.put("a", 2);
        map.put("b", null);
        System.out.println(map);
    }

}
