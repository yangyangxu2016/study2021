package com.example.demo.algorithm;

/**
 * 698. 划分为k个相等的子集
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/solution/javahui-su-jian-zhi-shou-ba-shou-jiao-hu-0equ/
 * date：2021/11/18  10:37 上午
 *
 * @author xuyy
 */
public class TestMain {



   static void traverse(int[] nums,int index ){
        if (index == nums.length) {
            return;
        }
        System.out.println(nums[index]);
        traverse(nums,index+1);
        System.out.println("结束了");
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};

        traverse(nums, 0);
    }


}
