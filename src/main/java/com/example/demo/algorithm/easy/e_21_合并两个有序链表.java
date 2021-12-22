package com.example.demo.algorithm.easy;


/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * date：2021/12/22  10:27 上午
 *
 * @author xuyy
 */
public class e_21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //哑结点
        ListNode dump = new ListNode(-1);
        //这个会动
        ListNode p = dump;
        ListNode p1 = list1;
        ListNode p2 = list2;

        //这个是&& ，都不为空才进行合并
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return dump.next;
    }


    public class ListNode {
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
