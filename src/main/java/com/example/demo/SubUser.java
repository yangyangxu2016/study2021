package com.example.demo;

/**
 * todo
 * date：2021/4/26  6:33 下午
 *
 * @author xuyy
 */
public class SubUser  extends User{

    public static void main(String[] args) {
        User user = new SubUser();
        user.getString();

    }

    @Override
    public Integer getId() {
        return 1;
    }
}
