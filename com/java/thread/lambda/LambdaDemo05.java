package com.java.thread.lambda;

import java.util.Arrays;

/**
 * @Author tqx
 * @CreateDate 2021/5/10
 * @Description Lambda表达式有参数有返回值的练习
 */
public class LambdaDemo05 {
    public static void main(String[] args) {
        invokeCalc(1, 3, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        invokeCalc(12, 23, (a, b) -> {
            return a + b;
        });
        invokeCalc(120, 23, (a, b) -> a + b
        );
    }

    public static void invokeCalc(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        System.out.println(sum);
    }
}
