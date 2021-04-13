package com.java.thread;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class MyThreadDaemon implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "在运行");
        }

    }

    public static void main(String[] args) {
        MyThreadDaemon mt1 = new MyThreadDaemon();
        Thread t = new Thread(mt1, "线程A");
        t.setDaemon(true);
        t.start();

    }
}
