package com.example.demo;


import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 * date：2021/11/17  10:50 上午
 *
 * @author xuyy
 */
public class Permute2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute2 solution = new Permute2();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> permute(int[] nums) {
        //    初始化
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }

        //    准备
        //记录是否走过
        boolean[] used = new boolean[length];
        //记录路径
        List<Integer> path = new ArrayList<>();
        def(nums, length, 0, path, used, res);
        //    返回
        return res;


    }

    private void def(int[] nums, int length, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        //    判断递归结束条件
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        //执行操作

        for (int i = 0; i < length; i++) {
            // 选择有效数据，判断是否走过了
            if (!used[i]) {
                //递归前
                path.add(nums[i]);
                used[i] = true;
                System.out.println("  递归之前 => " + path);

                //执行递归
                def(nums, length, depth + 1, path, used, res);

                //处理尾部操作
                used[i] = false;
                path.remove(path.size() - 1);
                System.out.println("递归之后 => " + path);
            }
        }


    }


}
