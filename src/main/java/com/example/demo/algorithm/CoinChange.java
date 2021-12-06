//package com.example.demo.algorithm;
//
//import java.util.Arrays;
//
///**
// * todo
// * date：2021/11/19  4:19 下午
// *
// * @author xuyy
// */
//public class CoinChange {
//
//
//    public int coinChange(int[] coins, int amount) {
//        memo = new int[amount + 1];
//        // dp 数组全都初始化为特殊值
//        Arrays.fill(memo, -666);
//        return dp(coins, amount);
//    }
//
//    public int dp(int[] coins,int amount){
//        if (amount == 0) return 0;
//        if (amount<0) return -1;
//
//        // 查备忘录，防止重复计算
//        if (memo[amount] != -666)
//            return memo[amount];
//
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins){
//            int subProblem = dp(coins, amount - coin);
//            if (subProblem == -1) continue;
//
//            res = Math.min(res, subProblem + 1);
//        }
//
//        // 把计算结果存入备忘录
//        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
//        return memo[amount];
//    }
//
//
//}
