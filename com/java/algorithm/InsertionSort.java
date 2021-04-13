package com.java.algorithm;

/**
 * @Author tqx
 * @CreateDate 2021/2/26
 * @Description 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {25, 32, 34, 56, 12, 13};
        int[] arr2 = insertSort(arr);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }

    /**
     * @Author tqx
     * @CreateDate 2021/2/26
     * @Description 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * ①. 从第一个元素开始，该元素可以认为已经被排序
     * ②. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * ③. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * ④. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * ⑤. 将新元素插入到该位置后
     * ⑥. 重复步骤②~⑤
     * @Param Return
     */
    public static int[] insertSort(int[] arr) {

        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;


        }
        return arr;
    }

    public static int[] insertSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        return arr;
    }
}
