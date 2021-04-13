package com.java;

import java.util.Arrays;

/**
 * @Author tqx
 * @CreateDate 2021/2/18
 * @Description TODO
 */
public class DemoSystem {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};
        System.out.println("复制前"+ Arrays.toString(dest));
        System.arraycopy(src,0,dest,0,3);
        System.out.println("复制后"+ Arrays.toString(dest));

    }
}
