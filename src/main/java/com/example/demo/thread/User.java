package com.example.demo.thread;

/**
 * todo
 * date：2021/4/26  6:33 下午
 *
 * @author xuyy
 */
public abstract class User {

    public static void testSync() {
        synchronized (User.class) {
            System.out.println("我是锁");
        }
    }

    public static void main(String[] args) {
        User.testSync();
    }
}
