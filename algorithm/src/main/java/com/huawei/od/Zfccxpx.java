package com.huawei.od;

import java.util.*;

/**
 * 题目描述
 * 给定一个字符串s，s包括以空格分隔的若干个单词，请对s进行如下处理后输出:
 * 1、单词内部调整:对每个单词字母重新按字典序排序Q
 * 2、单词间顺序调整:
 * 1)统计每个单词出现的次数，并按次数降序排列Q
 * 2)次数相同，按单词长度升序排列
 * 3)次数和单词长度均相同，按字典升序排列
 * 请输出处理后的字符串，每个单词以一个空格分隔。
 * 输入描述
 * 一行字符串，每个字符取值范围:[a-zA-z0-9]以及空格，字符串长度范围:[1，1000]
 * 输出描述
 * 输出处理后的字符串，每个单词以一个空格分隔。
 * 用例
 * 输入
 * This is an apple
 * 输出
 * an is This aelpp
 * 输入
 * My sister is in the house not in the yard
 * 输出
 * in in eht eht My is not adry ehosueirsst
 */
public class Zfccxpx {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        System.out.println(getResult(arr));
    }

    public static String getResult(String[] arr) {
        // 单词内部排序
        arr = Arrays.stream(arr).map(str -> {
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            return new String(cArr);
        }).toArray(String[]::new);

        // 统计词频
        Map<String, Integer> count = new HashMap<>();
        for (String s : arr) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        // 单词间排序
        Arrays.sort(arr, (a, b) -> !count.get(a).equals(count.get(b)) ? count.get(b) - count.get(a) : (a.length() != b.length() ? a.length() - b.length() : a.compareTo(b)));
        StringJoiner sj = new StringJoiner(" ","","");
        for (String s : arr) {
            sj.add(s);
        }
        return sj.toString();
    }

}
