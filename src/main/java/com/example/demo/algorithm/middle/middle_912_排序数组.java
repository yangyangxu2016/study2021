package com.example.demo.algorithm.middle;


import java.util.Arrays;

/**
 * todo
 * date：2021/11/22  10:46 上午
 *
 * @author xuyy
 */
public class middle_912_排序数组 {


    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        //nums = selectSort(nums);
        nums = fast(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static int[] fast(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        ///切分数组
        fastSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void fastSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        fastSort(nums, l, p - 1);
        fastSort(nums, p + 1, r);
    }
    //3
    private static int partition(int[] nums, int l, int r) {
        int prvot = nums[r];
        int start = l;
        for (int i = l; i < r; i++) {
            if (nums[l] < prvot) {
                swap(nums, start, i);
                start++;
            }

        }
        swap(nums, start, r);
        return start;
    }


    public static int[] bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean falg = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    falg = true;
                }
            }
            if (!falg == true) {
                break;
            }
        }
        return nums;
    }


    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;

        }

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (i == minIndex) {
                continue;
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }


    public static int[] quickFast(int[] nums){
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        quickFast(nums, 0, len-1 );

        return nums;
    }

    private static void quickFast(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = partition(nums, l, r);
        quickFast(nums, l, q - 1);
        quickFast(nums, q + 1, r);
    }


    private static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
