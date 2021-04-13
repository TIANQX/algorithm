package com.java.thread;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class MyThreadRunnable implements Runnable {
    private String name;

    public MyThreadRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+name + "运行，i=" + i);
        }
    }

    public static void main(String[] args) {
        MyThreadRunnable mt1 = new MyThreadRunnable("线程a");
        MyThreadRunnable mt2 = new MyThreadRunnable("线程b");
        Thread t1=new Thread(mt1);
        Thread t2=new Thread(mt2);
        t1.start();
        t2.start();
    }
}
