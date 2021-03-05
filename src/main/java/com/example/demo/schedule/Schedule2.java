package com.example.demo.schedule;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 实现接口的方式可以通过将cron表达式保存到数据库中，从数据库中读取从而改变执行时间。
 * 这里注意的是通过实现接口重新方法的方式实现定时任务，需要在任务类或者启动类上@EnableScheduling
 * <p>
 * https://blog.csdn.net/a718515028/article/details/80396102
 * 加载顺序，SchedulingConfigurer –> TaskScheduler –>ScheduledExecutorService
 * * TaskScheduler 和ScheduledExecutorService 会优先根据类型找，如果存在多个同类型的，则根据默认的名字“taskScheduler”来找
 * author：xuyy
 * date：2021/3/4  4:27 下午
 */
@Slf4j
//@Configuration
//@EnableScheduling
public class Schedule2 implements SchedulingConfigurer {

    @Resource
    private CronMapper cronMapper;


    /**
     * 1.1 这里设置，直接使用
     * scheduledTaskRegistrar.setScheduler(threadPoolTaskScheduler());
     *
     * @param scheduledTaskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //1.1 这里设置，直接使用
        //scheduledTaskRegistrar.setScheduler(threadPoolTaskScheduler());
        System.out.println("configureTasks trigger cwh");
        // cron表达式触发器
        scheduledTaskRegistrar.addTriggerTask(
                // 1.添加任务内容(Runnable)
                this::handleStrangerB3RMessage,
                // 2.设置执行周期(Trigger) 每 1s 执行一次
                //任务触发，可修改任务的执行周期.
                //每一次任务触发，都会执行这里的方法一次，重新获取下一次的执行时间
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext triggerContext) {
                        //3、读取数据库配置
                        Cron c = cronMapper.selectByPrimaryKey();
                        String cron = c.getCron();
                        CronTrigger cronTrigger = new CronTrigger(cron);

                        Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);
                        return nextExecutionTime;
                    }
                });

    }

    /**
     * 1、2 ：如果1.1不设置，根据TaskScheduler 的实现类查找该类
     *
     * @return
     */
    //@Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        // 设置线程名称
        ThreadFactory namedThreadFactory =
                new ThreadFactoryBuilder().setNameFormat("stranger-B3R-redis-listener-%d").build();
        // 创建线程池
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadFactory(namedThreadFactory);
        threadPoolTaskScheduler.initialize();
        return threadPoolTaskScheduler;
    }


    /**
     * 1、3 ScheduledExecutorService 实现类
     *
     * @return
     */
    //@Bean
    public Executor TaskScheduler() {
        return Executors.newScheduledThreadPool(10);
    }


    public void handleStrangerB3RMessage() {
        log.info("实现接口方式:{}", LocalDateTime.now());
    }
}
