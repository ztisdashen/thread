package com.mrma.t8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 14:18
 **/
public class T {
    /*volatile*/ int count = 0;
    AtomicInteger c = new AtomicInteger(0);

    public static void main(String[] args) {
        T t = new T();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(t::m, "thread " + i));
        }

        list.forEach(Thread::start);
        list.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);


    }

    synchronized void m() {
        for (int i = 0; i < 10000; i++) {

            count++;
        }
    }
}
