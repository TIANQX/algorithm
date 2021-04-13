package com.java;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author tqx
 * @CreateDate 2021/1/19
 * @Description TODO
 */
public class RandomTest {
//    public static void main(String[] args) {
//        Random r = new Random();
//        int num = r.nextInt();
//        System.out.println(num);
//    }

    public static void main(String[] args) {
        Random r = new Random();
        int rNum = r.nextInt(10);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int inNum = scanner.nextInt();
            if (inNum > rNum) {
                System.out.println("太大了");
            } else if (inNum < rNum) {
                System.out.println("太小了");
            } else {
                System.out.println("猜中了");
                break;
            }
        }
    }
}
