package com.example.demo.algorithm.middle;

/**
 * todo
 * date：2022/3/28  8:02 上午
 *
 * @author xuyy
 */
public class 两数相加 {


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newNode = new ListNode(-1);
        ListNode curr = newNode;

        //这里记录进位
        int carry = 0;
        while (p1 != null || p2 != null) {
            //定位数值 我们是|| 短的直接赋0值
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;


            //计算进位 这个操作秒，先进位加
            int sum = x + y + carry;
            carry = sum / 10;// 除以10，直接算出来了
            int z = sum % 10; //求余数，算出个位数

            // 添加新节点
            ListNode temp = new ListNode(z);
            curr.next = temp;
            curr = curr.next;

            //往前走  因为是|| 所有一直往前走
            p1 = p1 == null ? p1 : p1.next;
            p2 = p2 == null ? p2 : p2.next;
        }

        //判断最后进位 ，一定要控制增加这个判断
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            curr.next = temp;
        }

        return newNode.next;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
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
