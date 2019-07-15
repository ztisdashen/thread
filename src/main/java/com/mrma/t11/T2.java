package com.mrma.t11;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 使用wait和notify，但是wait会释放锁，notify不会释放锁，一旦执行notify，他就一定会执行完才会释放锁
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 17:52
 **/
public class T2 {
    private volatile List list = new ArrayList();

    public static void main(String[] args) {
        T2 t = new T2();
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 begin");
                if (t.size() != 5) {
                    try {
                        System.out.println("我要睡了");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end");
                System.exit(0);
            }
        }, "t2").start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 begin");
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());
                    System.out.println("size " + t.size());
                    if (t.size() == 5) {
                        System.out.println("摇醒了");
                        lock.notify();
                        
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, "t1").start();

    }

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }
}
