package com.csdn.teat_object;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 10:46
 **/


public class ObjectService {
    final String lock = "";
    private String uname;
    private String pwd;

    public void setUserNamePassWord(String userName, String passWord) {
        try {
            synchronized (lock) {
                System.out.println("thread name=" + Thread.currentThread().getName()
                        + " 进入代码快:" + System.currentTimeMillis());
                uname = userName;
                Thread.sleep(3000);
                pwd = passWord;
                System.out.println("thread name=" + Thread.currentThread().getName()
                        + " 进入代码快:" + System.currentTimeMillis() + "入参uname:" + uname + "入参pwd:" + pwd);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setUserNamePassWord2(String userName, String passWord) {
        try {

            synchronized (lock) {
                System.out.println("thread name=" + Thread.currentThread().getName()
                        + " 进入代码快:" + System.currentTimeMillis());
                uname = userName;
                Thread.sleep(3000);
                pwd = passWord;
                System.out.println("thread name=" + Thread.currentThread().getName()
                        + " 进入代码快:" + System.currentTimeMillis() + "入参uname:" + uname + "入参pwd:" + pwd);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}