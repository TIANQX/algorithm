package com.java.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author tqx
 * @CreateDate 2021/5/9
 * @Description 线程池
 */
public class ThreadPoolDemo01 {
    public static void main(String[] args) {
        //1.使用线程池的工厂类Executors里的静态方法newFixedThreadPool生产一个指定数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //2.调用ExecutorService中的submit方法，传递线程任务（实现类），开启线程，执行run方法
        es.submit(new RunnableImpl());
        //3.线程池会一直开启，使用完线程，会自动把线程归还给线程池，线程可以继续使用
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        //4.调用ExecutorService中的shutdown销毁线程池（不建议执行）
        es.shutdown();
        //es.submit(new RunnableImpl());//抛出异常，线程池都没有了，就不能获得线程了

    }
}
