package com.example.demo.algorithm.middle;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

/**
 * todo
 * date：2021/12/7  7:43 上午
 *
 * @author xuyy
 */
public class m_114_二叉数展开为链表 {

    public void flatten(TreeNode root) {

        //    base case
        if (root == null) {
            return;
        }

        //    后续遍历
        flatten(root.left);
        flatten(root.right);

        //    处理root

        //1、摊平左右节点
        TreeNode left = root.left;
        TreeNode right = root.right;

        //2、左几点挂到右节点树上去

        root.left = null;
        root.right = left;

    //    3. 寻找右子树最后节点，将原来右子树挂上去
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
