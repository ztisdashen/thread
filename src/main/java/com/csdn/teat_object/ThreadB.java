package com.csdn.teat_object;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 10:48
 **/

public class ThreadB extends Thread {
    private ObjectService objectService;

    public ThreadB(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.setUserNamePassWord2("b", "bb");
    }
}