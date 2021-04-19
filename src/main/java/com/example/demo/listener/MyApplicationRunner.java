package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * todo
 * date：2021/3/24  6:00 下午
 *
 * @author xuyy
 */
@Slf4j
@Order(4)
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String name = Thread.currentThread().getName();
        log.info("thread name is [" + name + "] ");
        log.info("MyApplicationRunner current parameter is: {}", args.getOptionValues("name"));

    }
}
