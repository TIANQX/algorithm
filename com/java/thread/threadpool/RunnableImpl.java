package com.java.thread.threadpool;

/**
 * @Author tqx
 * @CreateDate 2021/5/9
 * @Description TODO
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建一个新的线程执行");
    }
}
