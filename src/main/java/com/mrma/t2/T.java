package com.mrma.t2;

/**
 * volatile关键字，是一个变量在多个线程内可见
 * A,B都用到一个变量，Java默认时线程A中的一份copy，这样如果线程B修改了改变量，则线程A未必知道
 * 使用volatile关键字，会强制让所有线程都读到
 *<p>
 * 在下面的代码
 * </p>
 * 但线程t1开始的时候，会把b的值读到t1线程的工作区，在运行过程中使用这个b的copy，并不会每次都去读取堆内存，
 * 这样当主内存修改了b的值，t1并不会感知到
 *<p>
 * volatile并不能保证多个线程共同修改b的值带来的不一致问题，也就是说volatile并不能替代synchronized
 * </p>
 * volatile不具有原子性,只具有可见性
 * java对于线程处理的内存模型：jmm Java Memory Model
 *  栈内存和堆内存都是主内存
 *  每个线程都有一个缓冲区，缓冲区的内容都是从主内存中读过来
 *           volatile
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 11:14
 * @version 1.0
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
