package com.zd.recursion;

/**
 * @Author tqx
 * @CreateDate 2021/5/24
 * @Description TODO
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
        System.out.println("--------------------");
        test2(5);


        System.out.println("****************");
        System.out.println(factorial(4));
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n:" + n);
    }

    public static void test2(int n) {
        if (n > 2) {
            test2(n - 1);
        } else {
            System.out.println("n:" + n);
        }
    }

    //阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }

    }
}
