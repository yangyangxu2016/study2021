package com.example.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * date：2021/11/21  4:46 下午
 *
 * @author xuyy
 */
public class middle_151_反转字符串中的单词 {

    /**
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     *
     * @param s
     * @return
     */
    public static  String reverseWords(String s) {
        if (s == null) return "";

        //获取新数组长度
        s = removeNoNeedBlank(s);

        char[] chars = s.toCharArray();

        reverse(chars, 0, s.length());
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, cur, i);
                cur = i+1;
            }
        }

        reverse(chars, cur, chars.length);
        return new String(chars, 0, chars.length);
    }

    private static  String removeNoNeedBlank(String s) {
        char[] chars = s.toCharArray();
        boolean isBlack = true;
        int len = 0;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            //
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                isBlack = false;
            } else if (!isBlack) {
                isBlack = true;
                chars[cur++] = chars[i];
            }
        }

        //    处理尾部
        if (chars[cur - 1] == ' ') {
            len = cur - 1;
        } else {
            len = cur;
        }
        return new String(chars,0,len);
    }

    private static  void reverse(char[] chars, int left, int right) {
        right--;
        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
     }

    public static void main(String[] args) {
        //System.out.println("6_"+removeNoNeedBlank("the sky is blue")+"_6");
        //System.out.println("6_"+removeNoNeedBlank("  the sky is blue  ")+"_6");
        //System.out.println("6_"+removeNoNeedBlank(" the sky is blue ")+"_6");
        //System.out.println("6_"+removeNoNeedBlank(" the sky    is blue ")+"_6");
        //
        //System.out.println(reverse("abcdefg", 0, 7));

        System.out.println(reverseWords("  the sky is blue  "));

    }


}
