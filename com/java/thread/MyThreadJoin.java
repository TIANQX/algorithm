package com.java.thread;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class MyThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行，i=" + i);
        }
    }

    public static void main(String[] args) {
        MyThreadJoin my = new MyThreadJoin();
        Thread t1 = new Thread(my, "线程");
        t1.start();
        for (int i = 0; i < 50; i++) {
            if (i > 10) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main线程运行--》" + i);
        }

    }
}
