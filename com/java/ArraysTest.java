package com.java;

import java.util.Arrays;

/**
 * @Author tqx
 * @CreateDate 2021/1/22
 * @Description 将一个字符串中的所有字符升序排列、倒叙打印
 */
public class ArraysTest {
    public static void main(String[] args) {
        String str = "sadfasdiji2o342352346vkzocpvkpsdvfz";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }

    }
}
