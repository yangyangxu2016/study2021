package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * todo
 * date：2021/3/24  7:46 下午
 *
 * @author xuyy
 */
@Slf4j
@Component
public class MyInitializingBeanAndPostConstruct implements InitializingBean {

    public MyInitializingBeanAndPostConstruct() {
        log.info("MyInitializingBeanAndPostConstruct-Construct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String name = Thread.currentThread().getName();
        log.info("thread name is [" + name + "] ");
        log.info("MyInitializingBeanAndPostConstruct-InitializingBean-afterPropertiesSet");
    }

    @PostConstruct
    public void init() {
        String name = Thread.currentThread().getName();
        log.info("thread name is [" + name + "] ");
        log.info("MyInitializingBeanAndPostConstruct-PostConstruct");

    }
}
