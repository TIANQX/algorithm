package com.java;

import java.security.Principal;

/**
 * @Author tqx
 * @CreateDate 2021/1/19
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 5, 3, 5, 2};
        System.out.println(getNum(arr));

    }

    /**
     * @Author tqx
     * @CreateDate 2021/1/19
     * @Description 现在有一个整数类型的数组，数组中素只有一个元素只出现一次，其余的元素都出现两次。
     * @Param Return返回出现一次的数字
     */
    public static int getNum(int[]                                                                      arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i];
        }
        return num;
    }
}
