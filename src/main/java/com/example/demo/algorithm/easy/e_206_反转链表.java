package com.example.demo.algorithm.easy;

/**
 * todo
 * date：2021/12/28  9:58 上午
 *
 * @author xuyy
 */
public class e_206_反转链表 {


    /**
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * @param head
     * @return
     */
    //public ListNode reverseList2(ListNode head) {
    //
    //    //    定义返回条件  只有一个节点了无需返回
    //    if (head == null || head.next == null) {
    //        return head;
    //    }
    //
    //
    //    //    处理
    //
    //
    //    //    反转
    //    head.next.next = head;
    //    head.next = null;zz
    //    //return last
    //
    //}


    /**
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            //处理指针反转
            curr.next = prev;
            prev = curr;

            curr = next;
        }
        return prev;
    }

}
