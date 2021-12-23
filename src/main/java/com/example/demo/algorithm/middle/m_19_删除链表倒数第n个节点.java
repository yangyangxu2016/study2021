package com.example.demo.algorithm.middle;

/**
 * todo
 * date：2021/12/23  10:23 上午
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author xuyy
 */
public class m_19_删除链表倒数第n个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //叶节点处理null指针
        ListNode dumy = new ListNode(-1);
        dumy.next = head;

        //找到第n+1个节点 ，注意n是头，防止空

        ListNode p = getKthFromEnd(dumy, n + 1);

        //    删除
        p.next = p.next.next;

        return dumy.next;
    }

    private ListNode getKthFromEnd(ListNode head, int k) {

        //快慢
        ListNode fast = head;
        ListNode slow = head;

        //快走
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //大家一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

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



