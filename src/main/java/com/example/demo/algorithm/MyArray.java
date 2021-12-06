package com.example.demo.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * todo
 * date：2021/11/27  7:18 下午
 *
 * @author xuyy
 */
public class MyArray {

    private int[] array = new int[]{3, 1, 2, 5, 4, 9};
    private int size;

    public MyArray(int cap) {
        //this.array = new int[cap];
        size = 6;
    }

    public static void main(String[] args) {
        MyArray array = new MyArray(6);
        System.out.println(JSON.toJSONString(array.array));
        array.delete(2);
        System.out.println(JSON.toJSONString(array.array));

    }

    public int delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        int delete = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[ + 1];
        }
        size--;
        return delete;
    }
}


