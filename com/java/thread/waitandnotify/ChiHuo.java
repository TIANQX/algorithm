package com.java.thread.waitandnotify;

/**
 * @Author tqx
 * @CreateDate 2021/4/15
 * @Description TODO
 */
public class ChiHuo extends Thread {
    private BaoZi baoZi;

    public ChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (baoZi.flag == false) {
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                baoZi.flag = false;
                baoZi.notify();
                System.out.println("chihuo正在执行");

                System.out.println("-----------------------");
            }


        }
    }
}
