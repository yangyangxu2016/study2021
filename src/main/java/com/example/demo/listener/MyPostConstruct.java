package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 通常我们会是在Spring框架中使用到@PostConstruct注解 该注解的方法在整个Bean初始化中的执行顺序：
 * Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
 *
 * @author xuyy
 */
@Slf4j
@Component
public class MyPostConstruct {

    public MyPostConstruct() {
        log.info("MyPostConstruct init ");
    }

    @PostConstruct
    public void init() {
        String name = Thread.currentThread().getName();
        log.info("thread name is [" + name + "] ");
        log.info("MyPostConstruct current parameter is: {}");

    }
}
