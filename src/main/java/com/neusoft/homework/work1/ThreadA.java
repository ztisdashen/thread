package com.neusoft.homework.work1;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 15:16
 **/
public class ThreadA extends Thread {

    public ThreadA(String name) {
        super(name);
    }


    @Override
    public void run() {
        synchronized (Work1.class){
        System.out.println(Thread.currentThread().getName()+"prime in (1,1000)");
        int count = 0;
        for(int i=1;i<=1000;i++){
            if(Work1.isPrime(i)){
                System.out.print(i+" ");
                count++;
            }

            if(count == 10){
                System.out.println();
                count = 0;
            }
        }
        System.out.println("end");
        System.err.println("---------------------------------");
        }
    }
}
