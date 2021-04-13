package com.java;

/**
 * @Author tqx
 * @CreateDate 2021/1/22
 * @Description TODO
 */
public class MathTest {
    public static void main(String[] args) {
        double min = -10.8;
        double max = 5.9;
        int count = 0;
        for (int i = (int) min; i < max; i++) {
            int abs = Math.abs(i);
            if (abs > 6.1 || abs < 2.1) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
