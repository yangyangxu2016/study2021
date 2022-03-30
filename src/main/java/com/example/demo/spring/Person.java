package com.example.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * todo
 * date：2022/2/26  1:45 下午
 *
 * @author xuyy
 */
//@Component
public class Person implements InitializingBean, DisposableBean,
        BeanNameAware, BeanFactoryAware {

    private String name;
    private String address;

    private BeanFactory beanFactory;
    private String beanName;


    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    //    init-method

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }


//     destroy-method

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    @PostConstruct
    public void init() {
        System.out.println("myInit1属性指定的初始化方法");
    }

    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
