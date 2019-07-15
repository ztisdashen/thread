package com.mrma.t3;

/**
 * 显然synchronized使线程同步，但不会影响m2，因为他没有synchronized，不属于这个同步体系
 * 运行m2方法不需要申请这把锁，因为它不需要同步
 *
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 11:40
 **/
public class T {
    public synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" m1.start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" m1.end");
    }

    public void m2(){
        System.out.println(Thread.currentThread().getName()+" m.start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+" m.end");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "T1 ").start();
        new Thread(t::m2,"T2 ").start();
    }
}
