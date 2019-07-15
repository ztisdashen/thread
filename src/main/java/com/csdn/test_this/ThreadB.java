package com.csdn.test_this;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 10:39
 **/

public class ThreadB extends Thread {
    private Service objectService;
    public ThreadB(Service objectService){
        super();
        this.objectService=objectService;
    }
    @Override
    public void run() {
        super.run();
        objectService.serviceMethodB();
    }
}