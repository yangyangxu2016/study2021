package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * todo
 * date：2021/3/24  6:00 下午
 *
 * @author xuyy
 */
@Order(5)
@Slf4j
@Component
public class MyCommandRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        String name = Thread.currentThread().getName();
        log.info("thread name is [" + name + "] ");
        if (args.length <= 0) {
            return;
        }

        for (int i = 0; i < args.length; i++) {
            log.info("MyCommandLineRunner current parameter is: {}", args[i]);
        }
    }
}
