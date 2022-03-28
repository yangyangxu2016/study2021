package com.example.demo.algorithm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 交替打印 1-100
 *
 * @author xuyy
 */
public class DoubleThreadPrint {
    private static volatile int total = 100;
    private static AtomicInteger atomicCount = new AtomicInteger(1);
    //private static  volatile int total = 100;
    private static volatile int count = 1;
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        //useSyn();
        //useAtomic();
        useSynAndflag();
    }

    private static void useAtomic() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (atomicCount.intValue() <= total) {
                if (atomicCount.intValue() % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + " : " + atomicCount.intValue());
                    atomicCount.getAndIncrement();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (atomicCount.intValue() <= total) {
                if (atomicCount.intValue() % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + atomicCount.intValue());
                    atomicCount.getAndIncrement();
                }
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1000);
        t2.start();

    }

    private static void useSyn() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (object) {
                while (count <= total) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + " : " + count);
                        count++;
                        object.notify();
                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        });

        Thread t2 = new Thread(() -> {
            synchronized (object) {
                while (count <= total) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " : " + count);
                        count++;
                        object.notify();
                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        TimeUnit.SECONDS.sleep(1000);
        t2.start();
    }


    //private static Object object = new Object();
    public static void useSynAndflag() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            Boolean flag = true;
            synchronized (object) {
                while (flag) {
                    for (int i = 1; i <= 100; i += 2) {
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                        if (i == 99) {
                            flag = false;
                            object.notify();
                            break;
                        }
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }, "t1");

        Thread t2 = new Thread(() -> {
            Boolean flag = true;
            synchronized (object) {
                while (flag) {
                    for (int i = 2; i <= 100; i += 2) {
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                        if (i == 100) {
                            flag = false;
                            object.notify();
                            break;
                        }
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }, "t2");


        t1.start();
        Thread.sleep(1000);
        t2.start();

    }


}
