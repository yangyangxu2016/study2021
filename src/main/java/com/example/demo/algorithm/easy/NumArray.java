package com.example.demo.algorithm.easy;

/**
 * todo
 * date：2021/12/9  7:41 下午
 *
 * @author xuyy
 */
public class NumArray {

    int[] res = {};

    public NumArray(int[] nums) {
        res = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            res[i+1] = res[i] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        return  res[right+1]-res[left];
    }



}
