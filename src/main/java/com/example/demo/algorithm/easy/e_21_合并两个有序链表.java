package com.example.demo.algorithm.easy;


/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * date：2021/12/22  10:27 上午
 *
 * @author xuyy
 */
public class e_21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dump = new ListNode(-1);

        ListNode newList = dump;

    //    分别遍历list1 和 list2 ,追加
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                newList.next = list1;
                list1 = list1.next;
            } else {
                newList.next = list2;
                list2 = list2.next;
            }
            //走一步
            newList = newList.next;

        }

    //    处理剩余链表
        if (list1 != null) {
            newList.next = list1;
        }
        if (list2 != null) {
            newList.next = list2;
        }
        return dump.next;

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
