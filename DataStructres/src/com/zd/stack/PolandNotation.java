package com.zd.stack;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tqx
 * @CreateDate 2021/5/19
 * @Description TODO 逆波兰表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        //先定义给逆波兰表达式
        //(30+4)×5-6  => 30 4 + 5 × 6 - => 164
        // 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
        //测试
        //说明为了方便，逆波兰表达式 的数字和符号使用空格隔开
        String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        int res = calculate(list);
        System.out.printf("表达式的结果为%d", res);
    }

    /*
    将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList中
    30 4 + 5 × 6 -
     */
    public static List<String> getListString(String suffixExpression) {
        List<String> list = new ArrayList<>();
        String[] split = suffixExpression.split(" ");
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //逆波兰表达式运算
     /*
        1)从左至右扫描，将3和4压入堆栈；
        2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
        3)将5入栈；
        4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
        5)将6入栈；
        6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }

        }

        return Integer.parseInt(stack.pop());
    }
}


