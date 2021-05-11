package com.java.thread.lambda;

/**
 * @Author tqx
 * @CreateDate 2021/5/9
 * @Description TODO
 */
public class LambdaDemo02 {
    public static void main(String[] args) {
        //使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程");
            }
        }).start();

        //lambda表达式
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"线程");
        }).start();


    }
}
