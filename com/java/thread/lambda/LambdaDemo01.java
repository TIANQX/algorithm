package com.java.thread.lambda;

/**
 * @Author tqx
 * @CreateDate 2021/5/9
 * @Description TODO
 */
public class LambdaDemo01 {
    public static void main(String[] args) {
        //第一种
       RunnableImpl run = new RunnableImpl();
       Thread thread=new Thread(run);
       thread.start();

       //第二种匿名内部类
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程");
            }
        };
        new Thread(r).start();

        //第三种
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程");
            }
        }).start();



    }
}
