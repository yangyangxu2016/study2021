package com.example.demo.algorithm.middle;

/**
 * todo
 * date：2022/3/29  10:27 上午
 *
 * @author xuyy
 */
public class m_7_整数反转 {


    public static int reverse2(int x) {

        return 0;
    }


    public static int reverse1(int x) {
        //处理溢出
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }

        //处理符号
        int sign = x >= 0 ? 1 : -1;
        x = x < 0 ? -x : x;

        //反转
        char[] oldChar = String.valueOf(x).toCharArray();
        int start = 0, end = oldChar.length - 1;
        while (start < end) {
            char temp = oldChar[start];
            oldChar[start] = oldChar[end];
            oldChar[end] = temp;

            start++;
            end--;
        }

        //转为整形
        long y = Long.valueOf(String.valueOf(oldChar));
        //处理溢出
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
            return 0;
        }
        x = (int) y;

        //添加符号
        return x * sign;
    }

    public static void main(String[] args) {
        int a = -2147483648;
        System.out.println(reverse2(a));
    }
}
