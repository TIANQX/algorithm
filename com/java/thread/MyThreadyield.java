package com.java.thread;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class MyThreadyield implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行，i=" + i);
            if (i == 2) {
                System.out.println("线程礼让");
                //礼让不一定成功，要看CPU的调度，不如A礼让B，A可能会再次抢到CPU的资源
                Thread.currentThread().yield();  //线程礼让
            }
        }

    }

    public static void main(String[] args) {
        MyThreadyield mt1 = new MyThreadyield();
        MyThreadyield mt2 = new MyThreadyield();
        MyThreadyield mt3 = new MyThreadyield();
        Thread t1 = new Thread(mt1, "线程A");
        Thread t2 = new Thread(mt2, "线程B");
        t1.start();
        t2.start();
    }
}
