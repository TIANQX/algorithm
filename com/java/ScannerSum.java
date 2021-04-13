package com.java;

import java.security.Principal;
import java.util.Scanner;

/**
 * @Author tqx
 * @CreateDate 2021/1/19
 * @Description TODO
 */
public class ScannerSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字");
        int a = scanner.nextInt();
        System.out.println("请输入数字");
        int b = scanner.nextInt();
        System.out.println(a + b);

    }

}
