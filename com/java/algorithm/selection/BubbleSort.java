package com.java.algorithm.selection;

/**
 * @Author tqx
 * @CreateDate 2021/4/9
 * @Description 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 5, 8, 7, 4, 9, 2, 1};
        sort(arr);
        print(arr);
    }

    static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    

    /**
     * @Author tqx
     * @CreateDate 2021/4/9
     * @Description 数组元素位置交换
     * @Param Return
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/4/9
     * @Description 打印数组
     * @Param Return
     */
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
    /**
     *@Author tqx
     *@CreateDate 2021/4/9
     *@Description 算法优化使最好时间复杂度为n
     *@Param 
     *Return 
     */ 
}
