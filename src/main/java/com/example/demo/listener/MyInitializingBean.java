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
public class MyInitializingBean implements InitializingBean {


    public MyInitializingBean() {
        log.info("MyInitializingBean init ");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String name = Thread.currentThread().getName();
        log.info("thread name is [" + name + "] ");
        log.info("MyInitializingBean current parameter is: {}");
    }


    @PostConstruct
    public void init() {
        String name = Thread.currentThread().getName();
        log.info("thread name is [" + name + "] ");
        log.info("MyInitializingBean-init current parameter is: {}");

    }
}
