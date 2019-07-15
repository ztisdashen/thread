package com.csdn.test_this;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 10:39
 **/
public class Main {

    public static void main(String[] args) {
        Service service=new Service();
        ThreadA a=new ThreadA(service);
        a.setName("a");
        a.start();
        ThreadB b=new ThreadB(service);
        b.setName("b");
        b.start();

    }
}
