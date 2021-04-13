package com.java.thread;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class MyThreadInterrupt implements Runnable {

    @Override
    public void run() {
        System.out.println("1、进入run方法");
        try {
            Thread.sleep(10000);
            System.out.println("2、结束休眠");
        } catch (InterruptedException e) {
            System.out.println("3、休眠被终止");
            return;//返回调用处
        }
        System.out.println("4、run正常结束");

    }

    public static void main(String[] args) {
        MyThreadInterrupt mt1 = new MyThreadInterrupt();
        Thread t = new Thread(mt1);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();//中断线程
    }
}
