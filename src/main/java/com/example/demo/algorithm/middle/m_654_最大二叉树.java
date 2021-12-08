package com.example.demo.algorithm.middle;

/**
 * todo
 * date：2021/12/8  7:50 上午
 *
 * @author xuyy
 */
public class m_654_最大二叉树 {


    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
    }

    private TreeNode helper(int[] nums, int lo, int hi) {
    //    basecase
            if (lo>hi) return null;
    //    寻找最大值
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for (int i = lo; i <=hi ; i++) {
            if (nums[i] > maxValue) {
                maxValue=nums[i];
                index = i;
            }
        }

    //    赋值根
        TreeNode root = new TreeNode(nums[index]);
    //    左
        root.left = helper(nums, lo, index - 1);
    //    右节点
        root.right = helper(nums, index + 1, hi);
    //    返回
        return root;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
