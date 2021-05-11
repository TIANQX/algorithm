package com.zd.sparsearray;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author tqx
 * @CreateDate 2021/5/7
 * @Description 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建原始二维数组
        // 0：表示没有棋子 1：表示白子 2:表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        // 输出原始二维数组
        System.out.println("***原始二维数组***");
        for (int[] row : chessArr1) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        // 1.遍历原始数组得到有效数据的个数sum
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int item : row) {
                if (item != 0) {
                    sum++;
                }
            }

        }
        // 2.根据sum创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 3.遍历二维数组，将二维数组有效数据存入到稀疏数组
        int count = 0; //用于记录是第几个非0数据
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //创建文件
        File file = new File("D:\\1.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //向文件写入稀疏数组
        try {
            FileWriter fw = new FileWriter(file);
            //fw.write("开始写入"+"\r\n");
            for (int[] row : sparseArr) {
                for (int item : row) {
                    fw.write(item + " ");
                }
                fw.write("\r\n");
            }
            //fw.write("开始完成"+"\r\n");
            fw.flush();
            fw.close();
            System.out.println("写入稀疏数组成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 输出稀疏数组
        System.out.println("***稀疏数组***");
        for (int[] row : sparseArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        System.out.println("***从文件中读取稀疏数组***");
        int[][] arr = toArrayByInputStreamReader2("D:\\1.txt");
        for (int[] row : arr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
      /*  // 将稀疏数组转换为二维数组
        // 1.读取稀疏数组的第一行，根据第一行创建原始二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2.在读取稀疏矩阵的后几行，赋值给原始二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }*/

        // 将稀疏数组转换为二维数组
        // 1.读取稀疏数组的第一行，根据第一行创建原始二维数组
        int chessArr2[][] = new int[arr[0][0]][arr[0][1]];
        // 2.在读取稀疏矩阵的后几行，赋值给原始二维数组
        for (int i = 1; i < arr.length; i++) {
            chessArr2[arr[i][0]][arr[i][1]] = arr[i][2];
        }


        System.out.println("***转换为原始二维数组***");
        for (int[] row : chessArr2) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    public static int[][] toArrayByInputStreamReader2(String fileName) {
        //使用ArrayList存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(fileName);
        try {
            InputStreamReader input = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(input);
            //按行读取
            String str;

            while ((str = bufferedReader.readLine()) != null) {
//                System.out.println("***按行读取***");
//                System.out.println(str);
                arrayList.add(str);
            }
            bufferedReader.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("***打印从文件读取的稀疏数组***");
//        for (String str : arrayList) {
//            System.out.println(str);
//        }
        //对arraylist中存储的字符串进行处理
        int rows = arrayList.size();
        int cols = arrayList.get(0).split(" ").length;
        int[][] sparseArr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String s = arrayList.get(i).split(" ")[j];
                sparseArr[i][j] = Integer.parseInt(s);
            }
        }
        return sparseArr;
    }
}
