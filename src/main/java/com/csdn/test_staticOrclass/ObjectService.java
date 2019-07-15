package com.csdn.test_staticOrclass;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 11:04
 **/

public class ObjectService {
    public synchronized static void methodA(){
        try {
            System.out.println("static methodA begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("static methodA end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  static void methodB(){
        synchronized (ObjectService.class) {
            System.out.println("static methodB begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
            System.out.println("static methodB end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
        }
    }
}