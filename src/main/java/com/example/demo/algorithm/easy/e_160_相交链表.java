package com.example.demo.algorithm.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * todo
 * date：2021/12/27  12:05 下午
 *
 * @author xuyy
 */
public class e_160_相交链表 {


    public static void main(String[] args) {
        ListNode headA1 = new ListNode(4);
        ListNode headA2 = new ListNode(1);


        ListNode headB1 = new ListNode(5);
        ListNode headB2 = new ListNode(6);
        ListNode headB3 = new ListNode(1);

        ListNode headC1 = new ListNode(8);
        ListNode headC2 = new ListNode(4);
        ListNode headC3 = new ListNode(5);

        ListNode headA = headA1;
        headA.next = headA2;
        headA2.next = headC1;


        ListNode headB = headB1;
        headB.next = headB2;
        headB2.next = headB3;
        headB3.next = headC1;

        headC1.next = headC2;
        headC2.next = headC3;

        System.out.println(getIntersectionNode1(headA, headB).val);
        System.out.println(getIntersectionNode2(headA, headB).val);
        System.out.println(getIntersectionNode3(headA, headB).val);

    }


    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {

            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }

        }

        return p1;
    }


    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        Set<ListNode> ans = new HashSet<>();
        while (headA != null) {
            ans.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (ans.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;

    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        while (headA != null) {
            ListNode dumpB = headB;
            while (dumpB != null) {
                if (headA == dumpB) {
                    return headA;
                }
                dumpB = dumpB.next;
            }
            headA = headA.next;
        }
        return null;
    }
}

