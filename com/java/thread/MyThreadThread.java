package com.java.thread;

/**
 * @Author tqx
 * @CreateDate 2021/1/20
 * @Description TODO
 */
public class MyThreadThread extends Thread {
    private String name;

    public MyThreadThread(String name) {
        this.name = name;
    }
    public MyThreadThread() {

    }
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name + "运行，i=" + i);
        }
    }


    public static void main(String[] args) {
        MyThreadThread mt1 = new MyThreadThread("线程A");
        MyThreadThread mt2 = new MyThreadThread("线程B");
        mt1.start();
        mt2.start();
    }
}
