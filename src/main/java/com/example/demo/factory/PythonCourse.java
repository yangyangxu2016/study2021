package com.example.demo.factory;

import com.example.demo.factory.ICourse;

/**
 * todo
 * date：2021/6/29  下午4:15
 *
 * @author xuyy
 */
public class PythonCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制python课程");
    }

}
