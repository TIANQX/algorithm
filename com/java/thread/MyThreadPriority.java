package com.java.thread;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class MyThreadPriority implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行，i=" + i);
        }

    }

    public static void main(String[] args) {
        MyThreadPriority mt1 = new MyThreadPriority();
        MyThreadPriority mt2 = new MyThreadPriority();
        MyThreadPriority mt3 = new MyThreadPriority();
        Thread t1 = new Thread(mt1, "线程A");
        Thread t2 = new Thread(mt2, "线程B");
        Thread t3 = new Thread(mt3, "线程C");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        t3.start();

    }
}
