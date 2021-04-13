package com.java;

import java.util.ArrayList;

/**
 * @Author tqx
 * @CreateDate 2021/1/19
 * @Description TODO
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        System.out.println(list);
        Person p1 = new Person("tom", 12);
        Person p2 = new Person("jim", 20);
        Person p3 = new Person("jack", 15);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }
        for(Person p:list){
            System.out.println(p.getName());
        }
        System.out.println(list);
    }
}
