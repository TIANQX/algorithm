package com.java.algorithm;

import java.util.ArrayList;


/**
 * @Author tqx
 * @CreateDate 2021/1/21
 * @Description 螺旋矩阵
 *
 */
public class Matrix {

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (row == 0 || (col == 0 && row == 0)) {
            return res;
        }
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;
        while (true) {
            if (res.size() == row * col) {
                break;
            }
            //从左到右
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            //从右上到右下
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            //从右到左
            for (int j = right; j >= left; j--) {
                res.add(matrix[bottom][j]);
            }
            bottom--;
            //从左下到左上
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2, 3,4},
                {14, 15, 16, 5},
                {13, 20, 17, 6},
                {12, 19, 18, 7},
                {11, 10, 9, 8},
        };
        ArrayList<Integer> res = spiralOrder(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + ",");
        }
        System.out.println("**************");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ",");
        }

    }
}



