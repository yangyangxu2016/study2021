package com.example.demo;

/**
 * todo
 * date：2021/4/26  6:33 下午
 *
 * @author xuyy
 */
public abstract class User {


    public abstract Integer getId();


    public void getString(){
        System.out.println(getId());
    }

    public static void main(String[] args) {
        //User user = new SubUser();
        //user.getString();

    }


}
