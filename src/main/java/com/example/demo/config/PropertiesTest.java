package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * yml加载不了，properties可以
 * date：2021/3/8  5:13 下午
 *
 * @author xuyy
 */
@Component
@ConfigurationProperties(prefix = "com.xuyy")
@PropertySource(value = {"classpath:config/user1.properties"})
@Data
public class PropertiesTest {

    private String name;
    private String pass;


    @Bean
    public void init3() {
        System.out.println("name " + name + " pass: " + pass);
    }

}
