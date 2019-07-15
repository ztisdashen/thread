package com.mrma.t10;

import java.util.concurrent.TimeUnit;

/**
 *
 * 不要以字符串常量作为锁定对象
 * <p>下面的例子中{@link #m()}和{@link #m2()}其实锁定的使用一个对象</p>
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 16:15
 **/
public class T {
    String m = "hi";
    String m2 = "hi";
    void m(){
        synchronized (m){
            while (true){
                System.out.println(Thread.currentThread().getName());
            }

        }
    }
    void m2(){
        synchronized (m2){
            while (true){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m2,"t2").start();
    }
}
