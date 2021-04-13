package com.java;

/**
 * @Author tqx
 * @CreateDate 2021/1/19
 * @Description TODO
 */
public class ArrayTest {
    public static void main(String[] args) {
        Person[] arr = new Person[3];
        Person p1 = new Person("tom", 12);
        Person p2 = new Person("jim", 20);
        Person p3 = new Person("jack", 15);
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;

        System.out.println(arr[1].getName());
    }


}
