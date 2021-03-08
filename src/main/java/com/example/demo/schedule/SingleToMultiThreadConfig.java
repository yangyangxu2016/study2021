package com.example.demo.schedule;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadFactory;

/**
 * 加载改配置，单线程变成多线程定时任务
 * author：xuyy
 * date：2021/3/4  6:02 下午
 */
//@Configuration
public class SingleToMultiThreadConfig {

    /**
     * //     * 1、2 ：如果1.1不设置，根据TaskScheduler 的实现类查找该类
     * //     *
     * //     * @return
     * //
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
}
