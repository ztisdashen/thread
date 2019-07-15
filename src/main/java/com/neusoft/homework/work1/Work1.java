package com.neusoft.homework.work1;

/**
 * 利用Thread实现，要求多线程求解某范围素数每个线程负责1000范围：
 * 线程1找1-1000；线程 2 找 1001-2000；线程 3 找2001-3000。
 * 编程程序将每个线程找到的素数及时打印。
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 14:57
 **/
public class Work1 {

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

    public static void main(String[] args) {
        new ThreadA("thread 1").start();
        new ThreadB("thread 2").start();
        new ThreadC("thread 3").start();
    }

}
