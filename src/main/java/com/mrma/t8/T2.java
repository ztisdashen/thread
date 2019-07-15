package com.mrma.t8;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 15:48
 **/
public class T2 {
    private int n = 1;
    synchronized void m(){
        long b = System.currentTimeMillis();
        System.out.println("m start");
        for(int i=0;i<1000000000;i++){
            this.n++;
        }
        long e = System.currentTimeMillis();

        System.out.println("m end");
        System.out.println("m "+((e-b) /1000F));
    }
}
