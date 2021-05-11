package com.java.thread.lambda;

import scala.reflect.runtime.SynchronizedSymbols;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author tqx
 * @CreateDate 2021/5/10
 * @Description Lambda表达式有参数有返回值的练习
 */
public class LambdaDemo04 {
    public static void main(String[] args) {

        Person[] arr = {new Person("tom", 12),
                new Person("jack", 18),
                new Person("tina", 10)
        };


        //匿名内部类实现排序
     /*   Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/

        //lambda
   /*     Arrays.sort(arr, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });*/

        Arrays.sort(arr, (Person o1, Person o2) ->
                o1.getAge() - o2.getAge()
        );

        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
