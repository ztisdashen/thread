package com.mrma.t11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <p>这里使用wait和notify可以做到</p>
 * <p>必须要让t2先执行</p>
 * <p>使用门闩Latch替代wait和notify进行通知</p>
 * <p>CountDownLatch不涉及锁定，当count=0时继续进行</p>
 * <p>当不涉及同步，只是设计线程的通信时，使用synchronized和wait，notify就太笨重了</p>
 * <strong><font color='red'>应该考虑countdownlatch,cyslibarrier/semphore</font></strong>
 *
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 18:13
 **/
public class T4 {
    private volatile List list = new ArrayList();

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        T4 t = new T4();
        new Thread(() -> {
            System.out.println("t2 begin");
            if (t.size() != 5) {
                try {
                    //latch的await不需要synchronized
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("t1 begin");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add " + i);
                if (t.size() == 5) {
                    //不需要synchronized
                    latch.countDown();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
