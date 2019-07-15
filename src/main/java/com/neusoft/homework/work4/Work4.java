package com.neusoft.homework.work4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: thread
 * @description:
 * @author: zt648
 * @create: 2019-07-15 15:37
 **/
public class Work4 {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true){
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime ldt = LocalDateTime.now();
                System.out.println(ldt.format(dt));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
