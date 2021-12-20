package com.example.demo.algorithm.middle;

/**
 * todo
 * date：2021/12/13  10:24 上午
 *
 * @author xuyy
 */
public class m_560_和为k的子数组 {


    public static void main(String[] args) {
        //输入：nums = [1,1,1], k = 2
        //输出：2
        Integer test = 1;
        if (test.equals(null)) {
            System.out.println(1);
        }
        Boolean is = null;
        if (is || test.equals(null)) {
            System.out.println(1);
        }

    }

    /**
     * 构建前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        //构建缀和数组
        int[] perNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            perNums[i + 1] = perNums[i] + nums[i];
        }
        int res = 0;
        //穷举所有子数组
        for (int i = 0; i < nums.length; i++) {
            //计算有几个j可以是 i->j 的差值为k
            for (int j =i ; j < nums.length; j++) {
                if (perNums[j+1] - perNums[i] == k) {
                    res++;
                }
            }

        }
        return res;
    }


}
