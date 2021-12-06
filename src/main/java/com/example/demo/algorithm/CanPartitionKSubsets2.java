package com.example.demo.algorithm;


/**
 * todo
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/solution/
 * date：2021/11/18  11:10 上午
 *
 * @author xuyy
 */
public class CanPartitionKSubsets2 {

    // 主函数
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        // k 个桶（集合），记录每个桶装的数字之和
        int[] bucket = new int[k];
        // 理论上每个桶（集合）中数字的和
        int target = sum / k;
        // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
        return backtrack(nums, 0, bucket, target);
    }

    // 递归穷举 nums 中的每个数字
   static boolean backtrack(
            int[] nums, int index, int[] bucket, int target) {
        //结束条件
        if (index == nums.length) {
            // 检查所有桶的数字之和是否都是 target
            for (int i = 0; i <bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            // nums 成功平分成 k 个子集
            return true;
        }

        // 穷举 nums[index] 可能装入的桶
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝，桶装装满了
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            // 将 nums[index] 装入 bucket[i]
            bucket[i] += nums[index];
            // 递归穷举下一个数字的选择
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
        }

        // nums[index] 装入哪个桶都不行
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums, 4));
    }
}
