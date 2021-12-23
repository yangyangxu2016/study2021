package com.example.demo.algorithm.easy;

/**
 * todo
 * date：2021/12/23  10:23 上午
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @author xuyy
 */
public class e_22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        //  快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //    快指针先找到第k个
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        //    循环 快慢 ，快=null 找到慢
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        //返回第k个节点
        return slow;
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



