package com.zw.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String s = "1,2,3";
        List list = Arrays.asList(s.split(","));
        list.stream().forEach(s1 -> System.out.println(s1));
        System.out.println( "Hello World!" );
    }
}
