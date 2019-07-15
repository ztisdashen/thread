package com.neusoft.homework.work2;

import com.neusoft.homework.work1.Work1;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 15:26
 **/
public class Work2 {
    synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"prime in (1,1000)");
        int count = 0;
        for(int i=1;i<=1000;i++){
            if(isPrime(i)){
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
    synchronized void m2(){
        System.out.println(Thread.currentThread().getName()+"prime in (1001,2000)");
        int count = 0;
        for(int i=1001;i<=2000;i++){
            if(isPrime(i)){
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
    synchronized void m3(){
        System.out.println(Thread.currentThread().getName()+" prime in (2001,3000)");
        int count = 0;
        for(int i=2001;i<=3000;i++){
            if(isPrime(i)){
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
    static boolean isPrime(int n)
    {
        boolean flag = true;
        if(n==1)
            return false;
        for(int i=2;i<n;i++){
            if(n % i == 0){
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Work2 w = new Work2();
        new Thread(w::m1,"线程1：").start();
        new Thread(w::m2,"线程2：").start();
        new Thread(w::m3,"线程3：").start();
    }
}
