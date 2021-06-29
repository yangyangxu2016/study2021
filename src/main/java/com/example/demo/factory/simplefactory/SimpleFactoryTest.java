package com.example.demo.factory.simplefactory;

import com.example.demo.factory.ICourse;
import com.example.demo.factory.JavaCourse;
import com.example.demo.factory.PythonCourse;

import java.util.Calendar;

/**
 * todo
 * date：2021/6/29  下午4:14
 *
 * @author xuyy
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        ICourse course = new JavaCourse();
        course.record();

        CourseFactory.createCourse1("java").record();
        CourseFactory.createCourse1("python").record();
        //CourseFactory.createCourse1("not").record();


        CourseFactory.createCourse2("com.example.demo.factory.JavaCourse").record();
        CourseFactory.createCourse2("com.example.demo.factory.PythonCourse").record();
        //CourseFactory.createCourse2("com.example.demo.factory.not").record();

        CourseFactory.createCourse3(JavaCourse.class).record();
        CourseFactory.createCourse3(PythonCourse.class).record();

        Calendar.getInstance();





    }
}
