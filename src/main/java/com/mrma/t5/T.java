package com.mrma.t5;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以使用另一个同步方法，一个线程已经拥有了某个对象的锁，再次申请的时候仍然会得到该对象的锁
 * 也就是说synchronized获得的锁是可重入的
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 12:33
 **/
public class T {
    synchronized void m1(){
        System.out.println("m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }

    synchronized void m2(){
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(" m2 ");
    }


    public static void main(String[] args) {
        new Thread(()->new T().m1(), "T1 ").start();
    }
}
