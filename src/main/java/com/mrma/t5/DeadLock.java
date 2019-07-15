package com.mrma.t5;

import java.io.ObjectInputStream;

/**
 *
 * 模拟死锁
 * 在m1要获取o2的锁的时候，o2的锁已经被m1拿走，同理m1也拿不到o1的锁，造成死锁
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 12:40
 **/

public class DeadLock {
    private final Object o1 = new Object();
    private  final Object o2 = new Object();
    public void m1(){
        synchronized(o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

                System.out.println("m1 "+Thread.currentThread().getName());
            }
        }
    }

    public void m2(){
        synchronized(o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("m2 "+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        new Thread(d::m1,"t1").start();
        new Thread(d::m2,"t2").start();
    }
}
