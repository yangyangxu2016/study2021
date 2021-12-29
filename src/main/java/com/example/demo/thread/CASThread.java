package com.example.demo.thread;

import org.springframework.util.StopWatch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo
 * date：2021/12/23  6:24 下午
 *
 * @author xuyy
 */
public class CASThread implements Runnable {

    private AtomicInteger total;
    private CountDownLatch latch;

    public CASThread(AtomicInteger total, CountDownLatch latch) {
        this.total = total;
        this.latch = latch;
    }

    @Override
    public void run() {
        while (!total.compareAndSet(total.get(), total.get() + 1)) { }
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        //StopWatch stopWatch = new StopWatch();
        //stopWatch.start();

        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(10000);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1000, 1000, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 10000; i++) {
            threadPoolExecutor.execute(new CASThread(atomicInteger, latch));
        }

        latch.await();
        System.out.println(atomicInteger.get());
        //System.out.println("消耗：" + stopWatch.getTime() + "ms");

    }

}
