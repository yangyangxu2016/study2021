package com.example.demo.factory;

import com.example.demo.factory.simplefactory.CourseFactory;

/**
 * todo
 * date：2021/6/29  下午4:14
 *
 * @author xuyy
 */
public interface ICourse {

    public void record();

    public static void main(String[] args) {
        ICourse course = new JavaCourse();
        course.record();

        CourseFactory.createCourse1("java").record();
        CourseFactory.createCourse1("python").record();
        CourseFactory.createCourse1("not").record();


        CourseFactory.createCourse2("com.example.demo.factory.JavaCourse").record();
        CourseFactory.createCourse2("com.example.demo.factory.PythonCourse").record();





    }
}
