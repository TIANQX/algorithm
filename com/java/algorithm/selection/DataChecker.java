package com.java.algorithm.selection;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author tqx
 * @CreateDate 2021/4/9
 * @Description 对数器
 */
public class DataChecker {
    public static void main(String[] args) {
        check();
    }

    static int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        return arr;
    }

    static void check() {
        int[] arr1 = generateRandomArray();
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        Arrays.sort(arr1);
        SelectionSort.sort(arr2);

        boolean same = true;
        for (int i = 0; i < arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                same = false;
            }
        }
        System.out.println(same == true ? "right" : "wrong");
    }


}
