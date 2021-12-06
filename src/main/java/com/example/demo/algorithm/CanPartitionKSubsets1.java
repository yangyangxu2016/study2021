package com.example.demo.algorithm;

import java.util.Arrays;

/**
 * todo
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/solution/
 * date：2021/11/18  11:10 上午
 *
 * @author xuyy
 */
public class CanPartitionKSubsets1 {


    /**
     * 递归
     * 回溯
     * 剪枝
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //计算目标和
        int sum = 0;
        for (int i : nums) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        //记录遍历过的位置
        boolean[] used = new boolean[nums.length];
        return dfs(nums, nums.length - 1, target, 0, k, used);
    }

    private boolean dfs(int[] nums, int begin, int target, int curSum, int k, boolean[] used) {
        //  递归结束
        if (k == 1) return true;

        if (curSum == target) {
            //还有k-1个
            return dfs(nums, nums.length - 1, target, 0, k - 1, used);
        }

        for (int i = begin; i > 0; i--) {
            if (used[i] == true) {
                continue;
            }
            //大于继续
            if (curSum + nums[i] > target) {
                continue;
            }

            used[i] = true;
            if (dfs(nums, i - 1, target, curSum + nums[i], k, used)) {
                return true;
            }
            //   回溯
            used[i] = false;
            while (i > 0 && nums[i - 1] == nums[i]) {
                i--;
            }
        }
        return false;
    }
}
