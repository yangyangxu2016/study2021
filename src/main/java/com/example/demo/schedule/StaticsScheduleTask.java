package com.example.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * 注解方式的优点是简单方便，同样的缺点也明显就是执行周期是固定的不能动态修改
 * 默认是单一线程，任务会排序提交到一个线程的线程池，依次执行
 * author：xuyy
 * date：2021/3/4  4:27 下午
 *
 * @author xuyy
 */
@Slf4j
@Configuration
//@EnableScheduling
public class StaticsScheduleTask {
    /**
     * 测试定时1s，内部任务小于1s，会每各一秒执行
     */
    @Scheduled(fixedRate = 1000)
    public void doTask1() {
        log.info("StaticTask_doTask1_start:{}", LocalTime.now());
        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //log.info("StaticTask_doTask1_end:{}", LocalTime.now());
    }

    /**
     * 测试定时1s，内部任务大于1s，耗时2s，时间会在任务执行完才会执行下一次定时任务
     */
    @Scheduled(fixedRate = 1000)
    public void doTask2() {
        log.info("StaticTask_doTask2_start:{}", LocalTime.now());
        try {
            TimeUnit.MICROSECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //log.info("StaticTask_doTask2_end:{}", LocalTime.now());
    }
}
