package com.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tqx
 * @CreateDate 2021/1/21
 * @Description 前序遍历二叉树（根左右）
 */
public class PreOrder {
    /**
     * @Author tqx
     * @CreateDate 2021/1/21
     * @Description 递归实现
     * @Param Return
     */
    public static List<Integer> preOrderRe(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        System.out.print(root.val);
        TreeNode leftTree = root.left;
        if (leftTree != null) {
            preOrderRe(leftTree);

        }
        TreeNode rightTree = root.right;
        if (rightTree != null) {
            preOrderRe(rightTree);
        }
        return list;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/1/21
     * @Description 迭代
     * @Param Return
     */
    public static List<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(6);
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(4);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        l2.left = l3;
        List<Integer> result = new ArrayList<>();
        result = preOrder(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }

    }
}
