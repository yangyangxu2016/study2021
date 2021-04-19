package com.example.demo.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo
 * date：2021/4/19  10:00 上午
 *
 * @author xuyy
 */
public class CountDowLatchTest {


    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    //    CountDownLatch countDownLatch = new CountDownLatch(10);
    //    for (int i = 0; i < 10; i++) {
    //        int finalI = i;
    //        new Thread(() -> {
    //            System.out.println(finalI);
    //            countDownLatch.countDown();
    //        }).start();
    //
    //    }
    //
    //    countDownLatch.await();
    //    System.out.println("end");
    //
        CountDowLatchTest test = new CountDowLatchTest();
        test.checkAll();
    }

    AtomicInteger count = new AtomicInteger();
    BlockingQueue queue1 = new ArrayBlockingQueue<>(100);
    BlockingQueue queue2 = new ArrayBlockingQueue<>(100);

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
        check();
    });

    public void check() {
        System.out.println("check = "+count.get());
        Object take1 = null;
        Object take2 = null;
        try {
            take1 = queue1.take();
            take2 = queue2.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(take1.toString() + take2.toString());
    }

    public  void checkAll() {
        Thread t1 = new Thread(() -> {
            while (isOk()) {
                System.out.println("t1 = "+count.incrementAndGet());
                try {
                    queue1.put("t1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (isOk()) {
                System.out.println("t2 = "+count.incrementAndGet());
                try {
                    queue2.put("t2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

    }

    private boolean isOk() {
        if (count.get() >=300) {
            return false;
        }
        return true;
    }
}
