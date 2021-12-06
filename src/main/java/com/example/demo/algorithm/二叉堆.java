package com.example.demo.algorithm;

import java.time.zone.ZoneRules;
import java.util.Arrays;
import java.util.zip.ZipEntry;

/**
 * todo
 * date：2021/12/4  9:34 上午
 *
 * @author xuyy
 */
public class 二叉堆 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));

    }

    /**
     * 构建二叉堆
     *
     * @param array
     */
    private static void buildHeap(int[] array) {
        //    找到最后一个非叶子节点，做下沉操作
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    /**
     * @param array       数组
     * @param parentIndex 待下沉的父节点坐标
     * @param length      数组长度
     */
    private static void downAdjust(int[] array, int parentIndex, int length) {
        
    }

    private static void upAdjust(int[] array) {
    }
}
