package com.java.thread.waitandnotify;

/**
 * @Author tqx
 * @CreateDate 2021/4/15
 * @Description TODO
 */
public class Demo {
    public static void main(String[] args) {
        //创建包子对象
        BaoZi baoZi = new BaoZi();
        //创建包子铺线程
    /*    BaoZiPu baoZiPu = new BaoZiPu(baoZi);
        ChiHuo chihuo = new ChiHuo(baoZi);
        baoZiPu.start();
        chihuo.start();*/

        new BaoZiPu(baoZi).start();
        new ChiHuo(baoZi).start();
    }
}
