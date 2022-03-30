package com.example.demo.algorithm.easy.e_125;

/**
 * todo
 * date：2022/2/26  9:18 上午
 *
 * @author xuyy
 */
public class _验证回文串 {


    public static void main(String[] args) {
        _验证回文串 api = new _验证回文串();
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome1 = api.isPalindrome1(s);
        boolean palindrome2 = api.isPalindrome2(s);
        System.out.println(palindrome1);
        System.out.println(palindrome2);

    }

    public boolean isPalindrome1(String s) {
        //判断长度
        int n = s.length();
        if (n < 2) {
            return true;
        }

        int left = 0;
        int right = n - 1;
        //双指针，往内逼近
        while (left < right) {
            while (left < right && !isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                    left++;
                    right--;
                }else{
                    return false;
                }
            }

        }
        return true;
    }



    public boolean isLetterOrDigit ( char a){
        return Character.isLetterOrDigit(a);
    }


    public boolean isPalindrome2(String s) {
        int n = s.length();

        //先处理数组
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder bs = new StringBuilder(sb).reverse();

        if (sb.toString().equals(bs.toString())) {
            return true;
        }
        return false;
    }


}
