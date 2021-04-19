package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * todo
 * date：2021/3/24  7:07 下午
 *
 * @author xuyy
 */
@Slf4j
@Component
@Order(30)
public class MyApplicationListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        String name = Thread.currentThread().getName();
        log.info("thread name is [" + name + "] ");
        log.info("MyApplicationListener current parameter is: {}",event.toString());
    }
}
