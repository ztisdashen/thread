package com.mrma.t4;

/**
 * 这里如果不对{@link Account#getBalance(String)}加锁，就会产生脏读的问题即你写的与读的不一致
 *
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 11:52
 **/
public class Account {
    String name;
    double balance;

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(() -> a.set("张同", 1333f), "t1 ").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double balance = a.getBalance("张同");
        System.out.println("balance: " + balance);
    }

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;

    }

    public double getBalance(String name) {
        return this.balance;
    }

}
