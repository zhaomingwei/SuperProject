package com.huawei.od;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 求单向链表Q中间的节点值，如果奇数个节点取中间，偶数个取偏右边的那个值。
 * 输入描述
 * 第一行链表头节点地址后续输入的节点数n
 * 后续输入每行表示一个节点，格式节点地址节点值下一个节点地址(-1表示空指针Q)
 * 输入保证链表不会出现环，并且可能存在一些节点不属干链表。
 * 输出描述
 * 单向链表中间的节点值
 *
 * 用例
 * 输入：
 * 00010 4
 * 00000 3 -1
 * 00010 5 12309
 * 11451 6 00000
 * 12309 7 11451
 * 输出
 * 6
 *
 * 输入：
 * 10000 3
 * 76892 7 12309
 * 12309 5 -1
 * 10000 1 76892
 * 输出
 * 7
 */
public class DanXiangLianBiaoCenter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String head = sc.next();
        int count = sc.nextInt();

        Map<String, String[]> nodes = new HashMap<>();
        for (int i=0;i<count;i++) {
            String addr = sc.next();
            String val = sc.next();
            String nextAddr = sc.next();
            nodes.put(addr, new String[]{val, nextAddr});
        }

        System.out.println(getResult(head, nodes));

    }

    public static String getResult(String head, Map<String, String[]> map) {
        LinkedList<String> ll = new LinkedList<>();

        String[] node = map.get(head);
        while(node != null) {
            ll.add(node[0]);
            node = map.get(node[1]);
        }
        int size = ll.size();
        // 向下取整，但是链表下标是0开始的，刚好偶数取偏右，奇数中间
        int mid = size / 2;
        return ll.get(mid);
    }

}
