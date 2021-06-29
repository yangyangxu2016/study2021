package com.example.demo.factory.simplefactory;

import com.example.demo.factory.ICourse;
import com.example.demo.factory.JavaCourse;
import com.example.demo.factory.PythonCourse;

/**
 * todo
 * date：2021/6/29  下午4:27
 *
 * @author xuyy
 */
public class CourseFactory {

    /**
     * 简单工厂
     * @param name
     * @return
     */
    public static ICourse createCourse1(String name) {

        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("python".equals(name)) {
            return new PythonCourse();
        } else {
            return null;
        }
    }

    /**
     * 传入类全限定名字
     * 需要强制转型
     * @param classname
     * @return
     */
    public static ICourse createCourse2(String classname) {

        if (!(null == classname || "".equals(classname))) {
            try {
                return (ICourse) Class.forName(classname).newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 传入类
     * 利用泛型
     * @param clazz
     * @return
     */
    public static ICourse createCourse3(Class< ?extends ICourse> clazz) {
        if (null != clazz) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }


        return null;
    }
}
