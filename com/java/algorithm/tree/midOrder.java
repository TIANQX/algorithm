package com.java.algorithm.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author tqx
 * @CreateDate 2021/1/21
 * @Description 中序遍历二叉树(左根右)
 */
public class midOrder {
    /**
     *@Author tqx
     *@CreateDate 2021/1/21
     *@Description 迭代
     *@Param
     *Return
     */
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        //定义待处理节点的栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            //因为中序先处理最左节点，父节点也处于待处理阶段，所以先将节点入栈
            stack.push(p);
            if ((p = p.left) == null) {
                //左节点为空，从栈中获取节点
                while (stack.size() > 0) {
                    //出栈
                    p = stack.pop();
                    //获取父节点的值
                    list.add(p.val);
                    //找到右节点
                    if ((p = p.right) != null) {
                        break;
                    }
                }
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
        ArrayList<Integer> result = new ArrayList<>();
        result = inorderTraversal(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }

    }

}
