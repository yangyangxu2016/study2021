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
    public ListNode reverseList2(ListNode head) {
        ListNode dumy = new ListNode(-1);

        while (head != null) {
            ListNode temp = head.next;

            //断开
            head.next = dumy.next;
            dumy.next = head;

            head = temp;
        }

        return dumy.next;
    }


    /**
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode curr = head;
            ListNode next = curr.next;//记录下一个节点
            //    断开
            curr.next = prev;
            //记录
            prev = curr;

            //    返回头结点
            head = next;
        }
        return prev;
    }
}
