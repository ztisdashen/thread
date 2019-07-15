package com.csdn.test_staticOrclass;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 11:05
 **/
public class ThreadB extends Thread {
    @Override
    public void run() {
        ObjectService.methodB();
    }
}