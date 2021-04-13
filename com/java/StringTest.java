package com.java;

import javax.print.DocFlavor;
import java.util.Scanner;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class StringTest {
    public static void main(String[] args) {
        stringCount();
        int[] array = {1, 2, 3};
        System.out.print(fromArrayToString(array));

    }

    /**
     * @Author tqx
     * @CreateDate 2021/1/22
     * @Description 将数组拼接为字符串
     * @Param Return
     */
    public static String fromArrayToString(int[] array) {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                str += "word" + array[i] + "]";
                return str;
            }
            str += "word" + array[i] + "#";
        }

        return str;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/1/22
     * @Description 统计各种字符出现的次数  大写、小写、数字、其他
     * @Param Return
     */
    public static void stringCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String input = sc.next();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;

        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if ('A' <= ch && ch <= 'Z') {
                countUpper++;
            }
            if ('a' <= ch && ch <= 'z') {
                countLower++;
            }
            if ('0' <= ch && ch <= '9') {
                countNumber++;
            } else {
                countOther++;
            }
        }
        System.out.println("大写字母有：" + countUpper);
        System.out.println("小写字母有：" + countLower);
        System.out.println("数字有：" + countNumber);
        System.out.println("其他：" + countOther);


    }


}
