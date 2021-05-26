package com.zd.stack;

import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tqx
 * @CreateDate 2021/5/19
 * @Description TODO 中缀转后缀
 */
public class PolandNotation2 {
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> inffixExpressionList = toInffixExperssionList(expression);
        List<String> suffixExpressionList = parseSuffixExpressionList(inffixExpressionList);
        System.out.println(calculate(suffixExpressionList));
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

    //中缀表达式转为list
    public static List<String> toInffixExperssionList(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;//指针用于遍历
        String str;//多位数拼接
        char c;//每遍历一个字符放到c中
        do {
            //非数字
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }

        } while (i < s.length());
        return list;
    }

    public static List<String> parseSuffixExpressionList(List<String> s) {

        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String item : s) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());

                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }

        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }


}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("不存在该运算符：" + operation);
                break;
        }
        return res;
    }

}


