package com.example.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 注解方式的优点是简单方便，同样的缺点也明显就是执行周期是固定的不能动态修改
 * 默认是单一线程
 * author：xuyy
 * date：2021/3/4  4:27 下午
 *
 * @author xuyy
 */
@Slf4j
@Configuration
@EnableScheduling
public class StaticTask {
    /**
     * 1s
     */
    //@Scheduled(cron = "0/1 * * * * ?" )
    @Scheduled(fixedRate = 1000)
    public void doTask1() {
        log.info("StaticTask_doTask1_start:{}", LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("StaticTask_doTask1_end:{}", LocalDateTime.now());
    }

    //@Scheduled(cron = "0/3 * * * * ?")
    @Scheduled(fixedRate = 1000)
    public void doTask2() {
        log.info("StaticTask_doTask2_start:{}", LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("StaticTask_doTask2_end:{}", LocalDateTime.now());
    }


}
