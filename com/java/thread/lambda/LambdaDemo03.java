package com.java.thread.lambda;

/**
 * @Author tqx
 * @CreateDate 2021/5/10
 * @Description TODO
 */
public class LambdaDemo03 {
    public static void main(String[] args) {
        //匿名内部类
        invokCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("zhixing");
            }
        });

        //lambda
        invokCook(() -> {
            System.out.println("zhixing lambda");
        });


        //优化省略lambda
        invokCook(() ->
                System.out.println("zhixing lambda")
        );
    }

    public static void invokCook(Cook cook) {
        cook.makeFood();
    }
}
