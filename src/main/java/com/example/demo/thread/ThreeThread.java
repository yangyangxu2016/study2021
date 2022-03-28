package com.example.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo
 * date：2021/4/26  6:33 下午
 *
 * @author xuyy
 */
public class ThreeThread {


    private static final ReentrantLock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();


    public static void main(String[] args) {

       final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("T1");
            }
        });

        final  Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2");
            }
        });

        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T3");
            }
        });


        t1.start();
        t2.start();
        t3.start();

    }

}
