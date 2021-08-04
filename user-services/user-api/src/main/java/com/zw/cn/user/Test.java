package com.zw.cn.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵威
 * @date 2021/6/1 8:53
 * @desc TODO
 */
public class Test {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        node2.setLeft(null);
        node2.setRight(null);

        TreeNode node3 = new TreeNode(3);

        node1.setLeft(node2);
        node1.setRight(node3);

        TreeNode node4 = new TreeNode(4);
        node4.setLeft(null);
        node4.setRight(null);

        TreeNode node5 = new TreeNode(5);
        node5.setLeft(null);
        node5.setRight(null);

        node3.setLeft(node4);
        node3.setRight(node5);

        System.out.println(serialize(node1));
        System.out.println(deserialize(serialize(node1)));
//        System.out.println(list.stream().filter(o -> o.equals("4")).findAny().orElse("-"));
//        String digits = "23";
//        letterCombinations(digits);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        void setLeft(TreeNode node){
            this.left = node;
        }

        void setRight(TreeNode node){
            this.right = node;
        }
    }

    public static String serialize(TreeNode root) {
        if (null == root){
            return "{}";
        }
        List<TreeNode> list = new ArrayList();
        list.add(root);
        //[1,2,3,null,null,4,5,null,null,null,null]
        for (int i=0;i<list.size();i++){
            TreeNode node = list.get(i);
            if (null == node){
                continue;
            }
            list.add(node.left);
            list.add(node.right);
        }
        //[1,2,3,null,null,4,5]
        while (list.get(list.size()-1)==null){
            list.remove(list.size()-1);
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(list.get(0).val);
        //{1,2,3,#,#,4,5}
        for (int i=1;i<list.size();i++){
            if (list.get(i)==null){
                sb.append(",#");
            } else {
                sb.append("," + list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if (null == data || "{}".equals(data)){
            return null;
        }
        String[] datas = data.substring(1, data.length()-1).split(",");
        List<TreeNode> queue = new ArrayList();
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(root);
        boolean isLeft = true;
        int index = 0;
        for (int i=1;i<datas.length;i++){
            if (!"#".equals(datas[i])){
                TreeNode node = new TreeNode(Integer.parseInt(datas[i]));
                if (isLeft){
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeft){
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }

}
