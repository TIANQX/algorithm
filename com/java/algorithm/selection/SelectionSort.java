package com.java.algorithm.selection;



/**
 * @Author tqx
 * @CreateDate 2021/4/9
 * @Description 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 2};
//        for (int i = 0; i < arr.length; i++) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                /*if (arr[j] < arr[minPos]) {
                    minPos = j;
                }*/
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            System.out.println("minPos:" + minPos);
            /*int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;*/
            swap(arr, i, minPos);
            System.out.println("经过第" + i + "次循环之后，数组内容是：");
          /*  for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + "  ");
            }*/
            print(arr);
        }
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }*/
//        print(arr);
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
     *@Description 优化（遍历一次找到最小值和最大值）
     *@Param
     *Return
     */


    /**
     * @Author tqx
     * @CreateDate 2021/4/9
     * @Description 写程序证明选择排序不稳定
     * @Param Return
     */

    /**
     *@Author tqx
     *@CreateDate 2021/4/9
     *@Description TODO
     *@Param 
     *Return 
     */ 
    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
//            System.out.println("minPos:" + minPos);
            swap(arr, i, minPos);
//            System.out.println("经过第" + i + "次循环之后，数组内容是：");
            print(arr);
        }
    }


}
