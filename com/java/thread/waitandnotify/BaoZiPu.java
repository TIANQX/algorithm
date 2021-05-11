package com.java.thread.waitandnotify;

import java.util.Objects;

/**
 * @Author tqx
 * @CreateDate 2021/4/15
 * @Description TODO
 */
public class BaoZiPu extends Thread {
    private BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (baoZi) {
                if (baoZi.flag = true) {
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("baozipu正在执行");
                if (count % 2 == 0) {
                    baoZi.pi = "111";
                    baoZi.xian = "111";
                    System.out.println(baoZi.pi + "--->" + baoZi.xian);
                } else {
                    baoZi.pi = "222";
                    baoZi.xian = "222";
                    System.out.println(baoZi.pi + "--->" + baoZi.xian);
                }
                System.out.println(baoZi.pi + "--->" + baoZi.xian+"----------");
                try {
                    wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi.flag = true;
                count++;
                baoZi.notify();
                System.out.println("baozipu已完成");
            }
        }
    }
}
