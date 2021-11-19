package com.example.demo.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 * date：2021/11/17  10:50 上午
 *
 * @author xuyy
 */
public class Permute1 {

    //结果数组
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        //路径
        LinkedList<Integer> track = new LinkedList<>();
        //
        backtrack(nums, track);
        return res;
    }

    //路径：
    //选择列表：
    //结束条件： 全部在track出现
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发了结束条件，
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合适的选择
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择，第一次全部进去
            track.add(nums[i]);
            //进入下一层，继续决策
            backtrack(nums, track);
            //    取消选择
            track.removeLast();
        }
    }
}
