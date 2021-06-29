package com.example.demo.factory.factorymethod;

import com.example.demo.factory.ICourse;
import com.example.demo.factory.JavaCourse;

/**
 * todo
 * date：2021/6/29  下午4:58
 *
 * @author xuyy
 */
public class JavaCourseFactoryImpl implements ICourseFactory {
    @Override
    public ICourse create() {
        System.out.println("创建 java 工厂");
        return new JavaCourse();
    }

}
