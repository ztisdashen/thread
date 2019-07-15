package com.csdn.test_this;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 10:38
 **/

public class ThreadA extends Thread {
    private Service objectService;
    public ThreadA(Service objectService){
        super();
        this.objectService=objectService;
    }
    @Override
    public void run() {
        super.run();
        objectService.serviceMethodA();
    }
}