package com.java.thread.lambda;

/**
 * @Author tqx
 * @CreateDate 2021/5/9
 * @Description TODO
 */
public class RunnableImpl implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程");
    }
}
