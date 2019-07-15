package com.csdn.test_this;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 10:37
 **/

public class Service {
    public void serviceMethodA(){
        try {
            synchronized (this) {
                System.out.println("A begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end   time="+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void serviceMethodB(){

            System.out.println("B begin time="+System.currentTimeMillis());
            System.out.println("B end   time="+System.currentTimeMillis());

    }
}