package com.example.demo.algorithm;


/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class FIB {

    public int fib(int n) {
        //base
        if(n==0 ) return 0;
        if( n ==1) return 1;

        // 状态转移
        int pre =0;
        int cur =1;
        for(int i=2;i<=n;i++){
            int sum = pre+cur;
            pre = cur;
            cur=sum;
        }

        return cur;

    }
}
