package com.neusoft.homework.work3;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 15:29
 **/
public class Work3 extends Thread{

    public Work3(String name) {
        super(name);
        this.setPriority(6);
    }


    @Override
    public void run() {
        for(int i=0;i<200;i++){
            System.out.println(Thread.currentThread().getName()+"正在执行");
        }
    }

    public static void main(String[] args) {
        new Work3("线程2").start();
        new T("线程1").start();
    }
}

class T extends Thread{


    public T(String name) {
        super(name);
        this.setPriority(10);
    }

    @Override
    public void run() {
        for(int i=0;i<200;i++){
            System.out.println(Thread.currentThread().getName()+"正在执行");
        }
    }
}
