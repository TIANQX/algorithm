package com.java.algorithm.selection;

/**
 * @Author tqx
 * @CreateDate 2021/4/12
 * @Description 插入排序
 */
public class Insertion {
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        sort2(arr);
        print(arr);
    }

    static void sort(int[] arr) {
        //抽出第i牌
        for (int i = 1; i < arr.length; i++) {
            //把第i张牌和它前一张牌比较，如果比前一张牌小，插到前边
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
       /*     for(int j=i;j>0 && arr[j]<arr[j-1];j--){  //
                swap(arr, j, j - 1);
            }*/
//            print(arr);
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
     * @Author tqx
     * @CreateDate 2021/4/12
     * @Description 用临时变量记录标记项，去掉swap方法
     * 在一个数组中，将第一个元素看作排序元素序列里的唯一元素，然后用临时变量tmp首先存放第二元素,即可在数组中空第二个元素位置（即此位置可被覆盖），
     * 将第二个元素与有序序列里面唯一一个元素进行比较，根据排序条件决定元素是否需要向后移动，然后有序序列元素加一，申请空间里面存放将要插进有序序列里面的元素；
     * @Param Return
     */
    static void sort2(int[] arr) {
        int i=0;



    }
}

