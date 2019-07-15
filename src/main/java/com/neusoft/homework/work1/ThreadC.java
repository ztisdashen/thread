package com.neusoft.homework.work1;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 15:18
 **/
public class ThreadC extends Thread {

    public ThreadC(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (Work1.class) {
            System.out.println(Thread.currentThread().getName() + " prime in (2001,3000)");
            int count = 0;
            for (int i = 2001; i <= 3000; i++) {
                if (Work1.isPrime(i)) {
                    System.out.print(i + " ");
                    count++;
                }

                if (count == 10) {
                    System.out.println();
                    count = 0;
                }
            }
            System.out.println("end");
            System.err.println("---------------------------------");
        }
    }
}
