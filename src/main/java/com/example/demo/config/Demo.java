package com.example.demo.config;

/**
 * todo
 * date：2022/3/24  10:40 上午
 *
 * @author xuyy
 */
public class Demo {


    public static void reverse(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        //reverse(arr);
        //Arrays.stream(arr).forEach(x -> System.out.println(x));


        //case1
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.pre = n1;

        n2.next = n3;
        n3.pre = n2;

        n3.next = n4;
        n4.pre = n3;

        deleteVal(n1, 2);

        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }

    }




    //编程题（2）
    //实现下面的函数：
    // 从一个双向链表中删除符合指定值的节点
    public static Node deleteVal(Node head, int val) {
        if (head == null) {
            return head;
        }

        Node dumy = new Node(-1);
        dumy.next = head;
        Node temp = dumy;
        //1 2 2 4
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return dumy.next;
    }
    public static class Node {
        public int val; // 节点值
        public Node next; // 指向下一个节点
        public Node pre; // 指向上一个节点

        public Node(int val) {
            this.val = val;
        }
    }


}
