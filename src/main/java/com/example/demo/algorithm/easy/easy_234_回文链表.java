package com.example.demo.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 * date：2022/2/26  9:54 上午
 *
 * @author xuyy
 */
public class easy_234_回文链表 {


    public static void main(String[] args) {
        //_验证回文串 api = new _验证回文串();
        //
        //boolean palindrome1 = api.isPalindrome1(s);
        //boolean palindrome2 = api.isPalindrome2(s);
        //System.out.println(palindrome1);
        //System.out.println(palindrome2);

    }


    public boolean isPalindrome1(ListNode head) {
        //复制到数组中去
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] ts = list.toArray(new Integer[0]);
        int left = 0;
        int right = ts.length-1;
        while (left < right) {
            if (!ts[left].equals(ts[right])) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}

