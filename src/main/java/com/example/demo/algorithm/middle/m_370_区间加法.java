package com.example.demo.algorithm.middle;

import java.util.Arrays;

/**
 * todo
 * date：2021/12/20  9:09 上午
 *
 * @author xuyy
 */
public class m_370_区间加法 {

    private static int[] diff;

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0};
        init(nums);
         nums = plus(nums, 1, 3, 2);
        System.out.println(Arrays.toString(nums));
        nums = plus(nums, 2, 4, 3);
        System.out.println(Arrays.toString(nums));
        nums = plus(nums, 0, 2, -2);
        System.out.println(Arrays.toString(nums));

    }

    public static void init(int[] nums) {
          diff = new int[nums.length];
    }

    public static int[] plus(int[] nums, int l, int r, int value) {
        //    1、构建差分数组
        diff = buildDiffArray(nums);
        //    2、对差分数据进行加减
        diff = increment(l, r, value);
        //    3、反推结果数据
        return result(nums, l, r);
    }

    private static int[] increment(int l, int r, int value) {
        diff[l] += value;
        if (r + 1 < diff.length) {
            diff[r + 1] -= value;
        }
        return diff;
    }

    private static int[] buildDiffArray(int[] nums) {
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        return diff;
    }

    private static int[] result(int[] nums, int l, int r) {
        int[] res = new int[nums.length];
        res[0] = diff[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}
