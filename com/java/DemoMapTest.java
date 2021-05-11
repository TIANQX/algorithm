package com.java;


import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author tqx
 * @CreateDate 2021/2/19
 * @Description TODO
 */
public class DemoMapTest {
    public static void main(String[] args) {
        //1。
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        //2.
        HashMap<Character, Integer> map = new HashMap<>();
        //3.
        char[] charArrays = str.toCharArray();
        for (char charArray : charArrays) {
            //4.
            if (map.containsKey(charArray)) {
                Integer value = map.get(charArray);
                value++;
                map.put(charArray, value);

            } else {
                map.put(charArray, 1);
            }

        }
        //5.
        for (Character character : map.keySet()) {
            System.out.println(character+"---->"+map.get(character));
        }

    }
}
