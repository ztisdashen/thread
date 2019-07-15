package com.mrma.t8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 15:50
 **/
public class T3 {
    private AtomicInteger n = new AtomicInteger(1);

    public static void main(String[] args) {

        T2 t2 = new T2();

        new Thread(t2::m, "t2").start();


        T3 t3 = new T3();
        new Thread(t3::m, "t3").start();

    }

    void m() {
        long b = System.currentTimeMillis();
        System.out.println("m3 start");
        for (int i = 1; i < 1000000000; i++) {
            n.incrementAndGet();
        }
        System.out.println("m3 end");
        long e = System.currentTimeMillis();
        System.out.println("m3 "+((e - b) / 1000F));

    }
}
