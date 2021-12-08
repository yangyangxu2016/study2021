package com.example.demo.algorithm.middle;


import sun.management.counter.perf.PerfInstrumentation;

import java.util.Arrays;

/**
 * todo
 * date：2021/11/22  10:46 上午
 *
 * @author xuyy
 */
public class middle_912_排序数组 {


    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        //nums = selectSort(nums);
        nums = quickFast(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;

        }

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (i == minIndex) {
                continue;
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }


    public static int[] quickFast(int[] nums){
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        quickFast(nums, 0, len-1 );
        return nums;
    }

    private static void quickFast(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = partition(nums, l, r);
        quickFast(nums, l, q - 1);
        quickFast(nums, q + 1, r);
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i=l;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
