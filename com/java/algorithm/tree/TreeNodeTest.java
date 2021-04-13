package com.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description 通过迭代方法中序遍历一个二叉树
 */
public class TreeNodeTest {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode tmp = root;
        while (null != tmp || !treeNodeStack.isEmpty()) {
            while (null != tmp) {
                treeNodeStack.push(tmp);
                tmp = tmp.left;
            }
            tmp = treeNodeStack.pop();
            result.add(tmp.val);
            tmp = tmp.right;
        }
        return result;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/1/20
     * @Description 通过递归调用的方法中序遍历一棵二叉树
     * @Param Return
     */
    public ArrayList<Integer> middleTravelTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //中序遍历先查找左叶子节点
        middleTravelTree(root.left);
        list.add(root.val);
        //再查找右叶子节点
        middleTravelTree(root.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNodeTest bean = new TreeNodeTest();
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
        System.out.println(root.toString());
        System.out.println("递归*************");
        List<Integer> result = new ArrayList<>();
        bean.middleTravelTree(root);
        System.out.println(result);
        System.out.println("迭代*************");
        System.out.println(bean.inorderTraversal(root));


    }
}
