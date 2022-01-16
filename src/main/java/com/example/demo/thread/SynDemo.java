package com.example.demo.thread;

/**
 * todo
 * date：2022/1/16  3:27 下午
 *
 * @author xuyy
 */
public class SynDemo {
    private static int count = 0;

    public  static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public synchronized static void incr1(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> SynDemo.incr()).start();
            //new Thread(() -> SynDemo.incr1()).start();
        }
        Thread.sleep(2000);
        System.out.println("运行结果"+count);
    }
}
