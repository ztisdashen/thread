package com.mrma.t6;

import java.util.concurrent.TimeUnit;

/**
 *
 * 一个同步方法是可以重入的
 * 在继承中也可能发生这种情形，子类调用父类的同步方法
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 12:57
 **/
public class T {
    synchronized void m(){
        System.out.println("m start ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Thread(()->new TT().m()).start();
    }
}

class TT extends T{
    @Override
    synchronized void m() {
        System.out.println("child start");
        super.m();
        System.out.println("child end");
    }
}
