package com.neusoft.homework.work1;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 15:17
 **/
public class ThreadB extends Thread {

    public ThreadB(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (Work1.class){
        System.out.println(Thread.currentThread().getName()+"prime in (1001,2000)");
        int count = 0;
        for(int i=1001;i<=2000;i++){
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
