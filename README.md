# 线程

## 东软睿道
### 进程与线程
####  进程
1. 进程：每个进程都有独立的代码和数据空间，进程的切换会有很大的开销
2. 多进程：在操作系统中能同时运行多个任务（程序）

#### 线程
*  线程：同一类线程共享代码和数据空间，每个线程有独立运行的栈和程序计数器，线程切换的开销小
*  多线程：在同一应用程序中有多个顺序流同时执行
### 线程安全
* 无论有多少个线程，这个程序能够按照正常的逻辑进行的，这就是线程安全

## 马士兵高并发编程


## synchronized(this)和 synchronize方法
synchronized(this){}与synchronize方法是等价的，在一个类中如果其他方法也是synchronize或者是synchronize(this)则代表在线程中，都是锁定这个对象。如果有线程访问某个synchronize，其他的synchronize也是会被阻塞的，也就是说他们用的对象监视器使用同一个
多个线程调用同一个对象中的不同名称的synchronized同步方法或synchronized(this)同步代码块时，是同步的。

1、synchronized同步方法

①对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；

②同一时间只有一个线程执行synchronized同步方法中的代码。

2、synchronized(this)同步代码块

①对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；

②同一时间只有一个线程执行synchronized同步方法中的代码。
```java
public class Service {
    public void serviceMethodA(){
        try {
            synchronized (this) {
                System.out.println("A begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end   time="+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void serviceMethodB(){

            System.out.println("B begin time="+System.currentTimeMillis());
            System.out.println("B end   time="+System.currentTimeMillis());

    }
}
```
```java
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
```
```javapublic class ThreadB extends Thread {
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
```


## synchronized(T.class)与 synchronized static 
因为在内存中同一个类只会有一个class，同时static也是类似的
```java
public class ObjectService {
    public synchronized static void methodA(){
        try {
            System.out.println("static methodA begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("static methodA end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  static void methodB(){
        synchronized (ObjectService.class) {
            System.out.println("static methodB begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
            System.out.println("static methodB end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
        }
    }
}
```
```java
public class ThreadA extends Thread {

    @Override
    public void run() {
        ObjectService.methodA();
    }
}
```

```java
public class ThreadB extends Thread {
    @Override
    public void run() {
        ObjectService.methodB();
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }
}
```
> console：
static methodA begin 线程名称:A times:1563160176556
static methodA end   线程名称:A times:1563160179585
static methodB begin 线程名称:B times:1563160179585
static methodB end   线程名称:B times:1563160179586

* 注：method中synchronized(ObjectService.class) 可以将methodB变成static结果相同

synchronized(t){}
这个结果取决于t的位置，如果将t放在全局变量中，他们持有同一个t对象，但是如果把他们放在局部变量中，就是就会持有不同的t对象导致串序执行
```java

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
```
```java
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
```
```java
public class ThreadA extends Thread {
    private ObjectService objectService;

    public ThreadA(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.setUserNamePassWord("a", "aa");
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        ObjectService service=new ObjectService();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b=new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
```
>console：
thread name=A 进入代码快:1563159670548
thread name=A 进入代码快:1563159673576入参uname:a入参pwd:aa
thread name=B 进入代码快:1563159673596
thread name=B 进入代码快:1563159676596入参uname:b入参pwd:bb

* 因为他们持有同一个lock对象，就会一起被同步

使用同一个监视对象的synchronized会被同时阻塞