package com.mrma.t11;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器，提供两个方法add和size
 * 写两个线程，线程1添加10个元素到容器中，线程2是实现监控元素的个数，当个数达到5个时，线程2给出提示并结束
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 16:21
 **/
public class T {
    private volatile List list = new ArrayList();

    public static void main(String[] args) {
        T t = new T();
        //使用死循环比较浪费性能
        Thread t2 =  new Thread(() -> {
            while (true){
                if(t.size() == 5){
                    System.out.println("size:"+t.size());
                    System.exit(0);
                }
            }
        }, "线程2");
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程1");


        t1.start();
        t2.start();

    }

    public void add(Object o) {
        System.out.println(Thread.currentThread().getName()+" "+this.list.size());
        list.add(o);
    }

    public int size() {
        return list.size();
    }
}
