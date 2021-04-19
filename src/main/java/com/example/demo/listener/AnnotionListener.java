package com.example.demo.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * todo
 * date：2021/3/24  6:02 下午
 *
 * @author xuyy
 */

@EnableAsync
@Component
public class AnnotionListener {


    /**
     * 异步执行
     */
    @Order(1)
    @Async
    @EventListener
    public void AnnotionAsyncListener(ApplicationReadyEvent event) {
        String name = Thread.currentThread().getName();
        System.out.println("thread name is " + name + " AnnotionSyncListener start " + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步执行、优先级高 2
     */
    @Order(1)
    @EventListener
    public void AnnotionSyncListener1(ApplicationReadyEvent event) {
        String name = Thread.currentThread().getName();
        System.out.println("thread name is " + name + " AnnotionSyncListener1 start " + LocalDateTime.now());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步执行、优先级低 2
     */
    @Order(2)
    @EventListener
    public void AnnotionSyncListener2(ApplicationReadyEvent event) {
        String name = Thread.currentThread().getName();
        System.out.println("thread name is " + name + " AnnotionSyncListener2 start " + LocalDateTime.now());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






}
