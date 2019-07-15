package com.mrma.t1;

import java.util.concurrent.TimeUnit;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 09:31
 **/
public class T implements Runnable{

    private  int count = 10;

    /**
     * run()方法中没有添加synchronized,同步方法导致会有多个线程同时访问run方法，使count--没有同步。
     * thread 4  count：5
     * thread 8  count：0
     * thread 9  count：0
     * thread 7  count：2
     * thread 6  count：3
     * thread 3  count：4
     * thread 2  count：7
     * thread 1  count：8
     * thread 0  count：9
     * thread 5  count：5
     * 同时我们看到count输出也是无序的
     * 当我们对count 使用volatile关键字，idea就会写出
     * <strong>count--这个操作不具有原子性，因为他是两个操作,不要用read and write</strong>
     * thread 3  count：6
     * thread 0  count：8
     * thread 2  count：5
     * thread 4  count：7
     * thread 1  count：8
     * 加锁：
     * thread 1  count：9
     * thread 2  count：8
     * thread 4  count：7
     * thread 3  count：6
     * thread 0  count：5
     * count也是有序的
     */

    @Override
    public synchronized void run() {
            count--;

        System.out.println(Thread.currentThread().getName() + "  count：" + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for(int i = 0;i<5;i++){
            new Thread(t,"thread "+ i).start();
        }

    }
}
