package com.mrma.t7;

import java.util.concurrent.TimeUnit;
import java.util.zip.CheckedOutputStream;

/**
 * 在程序执行过程中，如果出现异常，默认情况下锁会被释放
 * 所以在并发处理过程中，有异常要多加小心，不然可能会发生不一致的情况
 * 比如在webapp中多个servlet线程共同访问同一个资源，这是如果异常处理不合适，在第一个线程
 * 中抛出异常，其他线程就会进入同步代码块，就有可能访问到异常产生时的数据
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 13:01
 **/
public class T {

    private int count = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" start");
        do {
            count++;

            System.out.println(Thread.currentThread().getName() + " count: " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = count / 0;
            }
        } while (true);

    }

    public static void main(String[] args)  {
        T t = new T();
        new Thread(t::m,"t").start();
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m,"t2");
    }
}
