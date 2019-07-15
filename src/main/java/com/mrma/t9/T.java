package com.mrma.t9;

import java.util.concurrent.TimeUnit;

/**
 *
 * synchronized(obj)锁的不是o,而是new出的对象
 * <p>锁定某对象o，如果o的属性发生改变，不影响锁的使用</p>
 * <p>但是如果o变成另一个对象，则锁定的对象发生改变</p>
 * <p>应该避免将锁的对象发生改变</p>
 * <p>锁是锁在堆内存中所new出的对象上，不是锁在栈内存中o的引用</p>
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 16:03
 **/
public class T {
    Object o = new Object();
    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m,"thread 1").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //t.o = new Object(); // 注掉，下面永远不会执行
        new Thread(t::m, "thread 2").start();
    }
}
