package com.java.throwable;

import java.util.Objects;

/**
 * @Author tqx
 * @CreateDate 2021/2/20
 * @Description TODO
 */
public class DemoObjects {
    public static void main(String[] args) {
        method(null);
    }

    public static void method(Object obj) {
      /*  if (obj == null) {
            throw new NullPointerException("null");
        }*/
        Objects.requireNonNull(obj);
    }
}
