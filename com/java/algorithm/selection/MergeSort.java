package com.java.algorithm.selection;

/**
 * @Author tqx
 * @CreateDate 2021/4/12
 * @Description 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort2(arr,0,arr.length-1);
//        print(arr);
//        sort(arr);
    }

    static void sort(int[] arr) {
//        merge(arr);
//        merge2(arr, 0, 4, arr.length - 1);
        merge2(arr, 1, 4, 5);
    }

    static void sort2(int[] arr,int left,int right) {
        if(left==right){
            return;
        }
//      分成两半
        int mid=left+(right-left)/2;
//      左边排序
        sort2(arr,left,mid);
//      右边排序
        sort2(arr,mid+1,right);
        merge2(arr, left, mid+1, right);
    }

    static void merge(int[] arr) {
        int mid = arr.length / 2;
        int[] temp = new int[arr.length];
        int i = 0;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j < arr.length) {
//            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j < arr.length) {
            temp[k++] = arr[j++];
        }
        print(temp);

    }

    static void merge2(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j <= rightBound) {
//            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j < rightPtr) {
            temp[k++] = arr[j++];
        }
        print(temp);

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
     * @CreateDate 2021/4/9
     * @Description 数组元素位置交换
     * @Param Return
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
