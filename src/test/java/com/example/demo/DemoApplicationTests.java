//package com.example.demo;
//
//import jodd.util.ThreadFactoryBuilder;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.IntStream;
//
//@Slf4j
////@SpringBootTest
//class DemoApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//
//    @Test
//    void testThreadPool() throws InterruptedException {
//        //不推荐使用
//        //队列0，每次新建一个线程，大量提交任务并且执行慢，肯产生OOM，无法创建新的线程
//        //Executors.newCachedThreadPool();
//        //固定线程数，但是队列是LinkedBlockingQueue，大量提交任务并且执行慢，可能产生OOM
//        //Executors.newFixedThreadPool(10);
//
//        //int test = test1();
//        //log.info("test:{}", test);
//
//    }
//
//    //private int test1() throws InterruptedException {
//    //    AtomicInteger atomicInteger = new AtomicInteger();
//    //
//    //    //定义合适的核心和最大线程数，合适的队列数量
//    //    ThreadPoolExecutor threadPoolExecutor = new ExtremeThreadPoolExecutor(
//    //            2, 5,
//    //            5l, TimeUnit.SECONDS,
//    //            10
//    //
//    //    );
//    //
//    //    //声明线程池立即达到最大核心线程数
//    //    //threadPoolExecutor.prestartAllCoreThreads();
//    //    //声明在核心线程空闲时，收回核心线程
//    //    //threadPoolExecutor.allowCoreThreadTimeOut(true);
//    //
//    //    IntStream.rangeClosed(1, 20).forEach(i -> {
//    //        try {
//    //            TimeUnit.SECONDS.sleep(1
//    //            );
//    //        } catch (InterruptedException e) {
//    //            e.printStackTrace();
//    //        }
//    //
//    //        int id = atomicInteger.incrementAndGet();
//    //
//    //        try {
//    //            threadPoolExecutor.submit(() -> {
//    //                log.info("{} start ", id);
//    //                try {
//    //                    TimeUnit.SECONDS.sleep(10);
//    //                } catch (InterruptedException e) {
//    //                    e.printStackTrace();
//    //                }
//    //                log.info("{} finished ", id);
//    //            });
//    //        } catch (Exception ex) {
//    //            log.error("id:{},ex:{}", id, ex);
//    //            atomicInteger.decrementAndGet();
//    //        }
//    //    });
//    //
//    //    TimeUnit.SECONDS.sleep(60);
//    //    return atomicInteger.intValue();
//    //}
//    //
//    //
//    //private int test() throws InterruptedException {
//    //    AtomicInteger atomicInteger = new AtomicInteger();
//    //
//    //    //定义合适的核心和最大线程数，合适的队列数量
//    //    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//    //            2, 5,
//    //            5l, TimeUnit.SECONDS,
//    //            new ArrayBlockingQueue<>(10),
//    //            new ThreadFactoryBuilder().withNameFormat("demo-threadPool-%d").get(),
//    //            new ThreadPoolExecutor.AbortPolicy()
//    //    );
//    //
//    //    //声明线程池立即达到最大核心线程数
//    //    threadPoolExecutor.prestartAllCoreThreads();
//    //    //声明在核心线程空闲时，收回核心线程
//    //    threadPoolExecutor.allowCoreThreadTimeOut(true);
//    //
//    //    IntStream.rangeClosed(1, 20).forEach(i -> {
//    //        try {
//    //            TimeUnit.SECONDS.sleep(1
//    //            );
//    //        } catch (InterruptedException e) {
//    //            e.printStackTrace();
//    //        }
//    //
//    //        int id = atomicInteger.incrementAndGet();
//    //
//    //        try {
//    //            threadPoolExecutor.submit(() -> {
//    //                log.info("{} start ", id);
//    //                try {
//    //                    TimeUnit.SECONDS.sleep(10);
//    //                } catch (InterruptedException e) {
//    //                    e.printStackTrace();
//    //                }
//    //                log.info("{} finished ", id);
//    //            });
//    //        } catch (Exception ex) {
//    //            log.error("id:{},ex:{}", id, ex);
//    //            atomicInteger.decrementAndGet();
//    //        }
//    //    });
//    //
//    //    TimeUnit.SECONDS.sleep(60);
//    //    return atomicInteger.intValue();
//    //}
//
//}
