package com.example.demo.algorithm;


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
        nums = selectSort(nums);

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
}
