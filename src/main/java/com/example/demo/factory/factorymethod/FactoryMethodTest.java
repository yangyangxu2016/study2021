package com.example.demo.factory.factorymethod;

import com.example.demo.factory.ICourse;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * todo
 * date：2021/6/29  下午4:14
 *
 * 适用场景：
 * 1、创建对象需要大量重复代码、逻辑较复杂
 * 2、客户端不依赖其产品的子类如何实现、创建等细节
 * 3、一个类通过其子类来实现创建哪个对象
 *
 * 缺点：
 * 1、类的个数太多
 * 2、增加系统复杂度和抽象度
 *
 * 案例：
 * 1、LoggerFactory.getILoggerFactory();
 * @author xuyy
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        //ICourseFactory factory = new JavaCourseFactoryImpl();
        //ICourse course = factory.create();
        //course.record();
        //
        //factory = new PythonCourseFactoryImpl();
        //course= factory.create();
        //course.record();
        //
        //LoggerFactory.getILoggerFactory();
        //System.out.println(11);
        ////LoggerFactory.getLogger()

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.yml");
        System.out.println(context);

    }
}
