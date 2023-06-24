package com.zw.cn.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的先序、中序、后序和层序的递归和非递归遍历
 *
 * 参考：<a href="https://blog.csdn.net/weixin_44259720/article/details/121494049">...</a>
 */
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = createTree();
        // 前序
        recursionPreorderTraversal(root);
        // 中序
        recursionMiddleOrderTraversal(root);
        // 后序
        recursionPostOrderTraversal(root);
    }

    /**
     * 先序遍历（根左右）：
     * <p>
     * 考察到一个节点后，立刻输出该节点的值，然后继续遍历其左右子树；
     * 根在前，从左往右，一棵树的根永远在左子树前面，左子树又永远在右子树前面；
     * 核心：先输出自己，再遍历子树。
     * <p>
     * —————————— 先序遍历：递归实现 ——————————
     */
    public static void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println("输出节点：" + root.val);
            recursionPreorderTraversal(root.left);
            recursionPreorderTraversal(root.right);
        }
    }

    /**
     * —————————— 先序遍历：非递归 ——————————
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print("输出节点：" + node.val);
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑，弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历（左根右）：
     *
     * 考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树；
     * 根在中，从左往右，一棵树的左子树永远在根前面，根永远在右子树前面；
     * 核心：自己的左子没有数据，才将自己输出。
     */
    /**
     * —————————— 中序遍历：递归 ——————————
     */
    public static void recursionMiddleOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleOrderTraversal(root.left);
            System.out.println("输出节点：" + root.val);
            recursionMiddleOrderTraversal(root.right);
        }
    }

    /**
     * —————————— 中序遍历：非递归 ——————————
     */
    public static void middleOrderTraversal(TreeNode root) {
        //if (root == null) {
        //    return;
        //}
        //Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        //TreeNode node = root;
        //while (node != null || !treeNodeStack.isEmpty()) {
        //    while (node != null) {
        //        treeNodeStack.push(node);
        //        node = node.left;
        //    }
        //    if (!treeNodeStack.isEmpty()) {
        //        node = treeNodeStack.pop();
        //        System.out.print("输出节点：" + node.val);
        //        node = node.right;
        //    }
        //}
        if (null == root){
            //return new ArrayList();
            return;
        }
        //List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            System.out.println("前序非递归输出节点:" + root.val);
            //list.add(root.val);
            root = root.right;
        }
        //return list;
    }

    /**
     * 后序遍历（左右根）：
     *
     * 考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值；
     * 根在后，从左往右，一棵树的左子树永远在右子树前面，右子树永远在根前面；
     * 核心：自己的左子和右子都没有数据，才将自己输出。
     */
    /**
     * —————————— 后序遍历：递归 ——————————
     */
    public static void recursionPostOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostOrderTraversal(root.left);
            recursionPostOrderTraversal(root.right);
            System.out.println("输出节点：" + root.val);
        }
    }

    /**
     * —————————— 后序遍历：非递归 ——————————
     */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastNode = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            // 查看当前栈顶元素
            node = treeNodeStack.peek();
            // 如果其右子树也为空，或者右子树已经访问过，则可以直接输出当前节点的值
            if (node.right == null || node.right == lastNode) {
                System.out.print("输出节点：" + node.val);
                treeNodeStack.pop();
                // 把输出的节点赋值给lastNode游标，作为下次比对的依据
                lastNode = node;
                node = null;
            }
            // 否则，继续遍历右子树
            else {
                node = node.right;
            }
        }
    }

    public static TreeNode createTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }


}
