package com.neusoft;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 14:45
 **/
class common {
    private char ch;
    private boolean bool = false;

    synchronized char get() {
        //定义同步方法
        //当bool为true是挂起线程
        while (!bool) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bool = false;
        notify(); //唤醒生产者线程
        return ch;
    }

    synchronized void put(char newchar) {
        //定义同步方法
        //当bool的为true，挂起线程
        while (bool) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ch = newchar;
        bool = true;
        notify(); //唤醒消费者教程
    }
}

class producer1 extends Thread {
    private common comm;

    public producer1(common comm) {
        this.comm = comm;
    }

    public void run() {
        char c;
        for (c = 'a'; c <= 'e'; c++) {
            System.out.println("生产数据是：" + c);
            comm.put(c);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

class consumer1 extends Thread {
    private common comm;

    public consumer1(common comm) {
        this.comm = comm;
    }

    public void run() {
        char c;
        for (int i = 0; i < 5; i++) {
            c = comm.get(); //调用同步方法get
            System.out.println("消费者得到的数据为" + c);
        }
    }
}

public class app10_10 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        common comm = new common();
        producer1 p = new producer1(comm);
        consumer1 c = new consumer1(comm);
        p.start();
        c.start();
    }

}
