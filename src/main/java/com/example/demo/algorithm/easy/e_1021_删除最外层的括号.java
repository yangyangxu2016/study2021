package com.example.demo.algorithm.easy;

/**
 * todo
 * date：2022/3/30  10:42 上午
 *
 * @author xuyy
 */
public class e_1021_删除最外层的括号 {

    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses1(s));
    }


    public static String removeOuterParentheses1(String s) {
        // 记录返回内容
        StringBuilder res = new StringBuilder();

        int left = 0, right = 0, last = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            char val = s.charAt(i);
            if (val=='('){
                left++;
            } else if (val==')') {
                right++;
            }
            if (left == right) {
                res.append(s.substring(++last, i));
                last = i + 1;
            }
            i++;
        }

        return res.toString();
    }


}
