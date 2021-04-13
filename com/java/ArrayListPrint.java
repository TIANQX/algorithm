package com.java;

import java.util.ArrayList;

/**
 * @Author tqx
 * @CreateDate 2021/1/19
 * @Description TODO
 */
public class ArrayListPrint {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("tom");
        list.add("tony");
        list.add("jack");
        System.out.println(list);
        printArrayList(list);

    }

    public static void printArrayList(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (i == (list.size() - 1)) {
                System.out.print(name);
            } else {
                System.out.print(name + "@");
            }
        }
        System.out.print("}");

    }
}
