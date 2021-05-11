package com.java.algorithm.selection;

import java.util.Arrays;

/**
 * @Author tqx
 * @CreateDate 2021/4/14
 * @Description 计数排序（量大取值范围小）
 */
public class CountSort {
    public static void main(String[] args) {
//        数组取值范围1~9
        int[] arr = {2, 4, 2, 3, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};
        int[] result = sort2(arr);
        System.out.println(Arrays.toString(result));
    }

    /**
     * @Author tqx
     * @CreateDate 2021/4/14
     * @Description 不稳定
     * @Param Return
     */
    static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];
//      计数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));

        for (int i = 0, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                result[j++] = i;
            }
        }

        return result;
    }


    /**
     * @Author tqx
     * @CreateDate 2021/4/14
     * @Description 稳定的（累加数组）
     * @Param Return
     */
    static int[] sort2(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

//        得到count数组
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));
//        得到count数组的累加数组
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println(Arrays.toString(count));

//        原来的数组倒序迭代
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
//            System.out.println(--count[arr[i]] + "--->" + arr[i]);
        }

        return result;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/4/14
     * @Description 固定范围的（100-150）
     * @Param Return
     */
    static int[] sort3(int[] arr) {
        return null;
    }

}
