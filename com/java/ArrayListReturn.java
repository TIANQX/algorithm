package com.java;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author tqx
 * @CreateDate 2021/1/19
 * @Description TODO
 */
public class ArrayListReturn {
    public static void main(String[] args) {
        ArrayList<Integer> BigList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(100) + 1;
            BigList.add(num);
        }

        ArrayList<Integer> smailList = getSmailList(BigList);
        System.out.println("小列表的长度是：" + smailList.size());
        for (int i = 0; i < smailList.size(); i++) {
            System.out.println(smailList.get(i));
        }
    }

    public static ArrayList<Integer> getSmailList(ArrayList<Integer> BigList) {
        ArrayList<Integer> smailList = new ArrayList<>();
        for (int i = 0; i < BigList.size(); i++) {
            if (BigList.get(i) % 2 == 0) {
                smailList.add(BigList.get(i));
            }
        }
        return smailList;
    }
}
