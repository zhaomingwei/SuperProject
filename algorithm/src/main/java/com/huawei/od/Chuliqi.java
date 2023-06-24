package com.huawei.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 处理器问题
 */
public class Chuliqi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] array = Arrays.stream(sc.nextLine().split("[\\[\\],\\s]"))
                .filter(str -> !"".equals(str))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);


    }

}
