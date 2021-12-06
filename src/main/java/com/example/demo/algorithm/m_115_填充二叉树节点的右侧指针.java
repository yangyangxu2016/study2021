package com.example.demo.algorithm;

/**
 * todo
 * date：2021/12/6  8:12 上午
 *
 * @author xuyy
 */
public class m_115_填充二叉树节点的右侧指针 {


    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            connectTwoNode(root.left, root.right);
            return root;
        }

        private void connectTwoNode(Node left, Node right) {
            //base case
            if (left == null || right == null) {
                return;
            }
            //两个节点相连
            left.next = right;

        //    前序遍历
            connectTwoNode(left.left, left.right);
            connectTwoNode(right.left, right.right);

        //   跨节点连接
            connectTwoNode(left.right, right.left);
        }
    }


    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
