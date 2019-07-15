package com.csdn.teat_object;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 10:49
 **/
public class Main {

    public static void main(String[] args) {
        ObjectService service=new ObjectService();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b=new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
