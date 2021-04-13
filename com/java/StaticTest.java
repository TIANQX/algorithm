package com.java;

/**
 * @Author tqx
 * @CreateDate 2021/1/22
 * @Description TODO
 */
public class StaticTest {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 23);
        s1.room = "103";
        System.out.println(s1.getName() + "**" + s1.getAge()
                + "**" + s1.getId() + "**" + s1.room);
        Student s2 = new Student("lisi", 12);
        System.out.println(s2.getName() + "**" + s2.getAge()
                + "**" + s2.getId() + "**" + s2.room);

    }
}

