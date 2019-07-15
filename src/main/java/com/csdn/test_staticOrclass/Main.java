package com.csdn.test_staticOrclass;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 11:06
 **/
public class Main {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }
}
