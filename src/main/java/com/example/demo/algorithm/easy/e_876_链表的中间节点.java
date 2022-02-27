package com.example.demo.algorithm.easy;

/**
 * todo
 * date：2022/2/27  2:57 下午
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author xuyy
 */
public class e_876_链表的中间节点 {

    //1 2 3 4 5
    //1 2 3 4 5 6
    public ListNode middleNode(ListNode head) {
        //奇数返回中间 偶数返回 第二个
    //    双指针

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
