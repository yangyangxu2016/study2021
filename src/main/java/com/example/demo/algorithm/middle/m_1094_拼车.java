package com.example.demo.algorithm.middle;

/**
 * https://leetcode-cn.com/problems/car-pooling/
 * date：2022/1/4  7:13 下午
 *
 * @author xuyy
 */
public class m_1094_拼车 {

    /**
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
     * 输出：true
     *
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        //    计算差分数组
        int[] diff = new int[1001];
        //    使用差分数组进行区间计算
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int[] res = new int[1001];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }

        for (int i = 0; i < res.length; i++) {
            if (res[0] > capacity) {
                return false;
            }
        }
        return true;
    }
}
