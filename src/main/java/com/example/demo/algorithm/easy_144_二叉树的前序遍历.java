package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * todo
 * date：2021/11/28  3:01 下午
 *
 * @author xuyy
 */
public class easy_144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                res.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return res;
    }

}