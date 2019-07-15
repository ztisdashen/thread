package com.mrma.t2;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 11:14
 **/
public class T {
    boolean b = true;
    public void dob(){
        System.out.println("begin");
        while (b){

        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::dob,"h").start();
        new Thread(t::dob,"h").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.b = false;
    }
}
