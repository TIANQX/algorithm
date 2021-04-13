package com.java.thread;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class MyThreadSynchronized implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("卖票：ticket=" + ticket--);
                }
            }

        }

    }

    public static void main(String[] args) {
        MyThreadSynchronized mt1 = new MyThreadSynchronized();

        Thread t1 = new Thread(mt1, "线程A");
        Thread t2 = new Thread(mt1, "线程B");
        Thread t3 = new Thread(mt1, "线程C");
        t1.start();
        t2.start();
        t3.start();
    }
}
