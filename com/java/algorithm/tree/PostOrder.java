package com.java.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tqx
 * @CreateDate 2021/1/21
 * @Description 后序遍历二叉树（左右根）
 */
public class PostOrder {
    /**
     * @Author tqx
     * @CreateDate 2021/1/21
     * @Description 递归
     * @Param Return
     */
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //后序遍历首先保留左子树
        postorderTraversal(root.left);
        //
        postorderTraversal(root.right);

        //保存根节点
        list.add(root.val);
        return list;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/1/21
     * @Description 迭代
     * @Param Return
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        //定义待处理节点的栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            //后序遍历最后保存根节点，将结果压栈
            list.push(p.val);
            if (p.left != null) {
                stack.push(p.left);
                //将右节点操作继续操作
                p = p.right;
                //如果右节点为空，从栈顶获取一个最近的一个节点操作（当栈中没有节点时，树已遍历完）
                if (p == null && stack.size() > 0) {
                    p = stack.pop();
                }
            }
        }
        return list;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/1/21
     * @Description 迭代
     * @Param Return
     */
    public static ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        //定义待处理节点的栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        //最后加入结果集的节点
        TreeNode pro = null;
        while (p != null) {
            //
            stack.push(p);
            p = p.left;
            while (p == null && stack.size() > 0) {
                p = stack.peek();
                if ((p = p.right) == null || p == pro) {
                    pro = stack.pop();
                    list.add(pro.val);
                    p = null;
                }
            }
        }
        //
        //

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
        ArrayList<Integer> result = new ArrayList<>();
        result = postorderTraversal2(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }

    }
}
