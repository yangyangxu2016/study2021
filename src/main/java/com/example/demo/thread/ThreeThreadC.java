package com.example.demo.thread;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo
 * date：2021/4/26  6:33 下午
 *
 * @author xuyy
 */
public class ThreeThreadC   {

    //private static AtomicInteger count = new AtomicInteger(0);
    private static int count = 0;

    private   static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10;) {
                lock.lock();
                if (count% 3 == 0) {
                    count++;
                    System.out.println("a"+count);
                    i++;
                }
                lock.unlock();

            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; ) {
                lock.lock();
                if (count % 3 == 1) {
                    count++;
                    System.out.println("b"+count);
                    i++;
                }
                lock.unlock();

            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; ) {
                lock.lock();
                if (count % 3 == 2) {
                    count++;
                    System.out.println("c"+count);
                    i++;
                }
                lock.unlock();
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();



    }

}
