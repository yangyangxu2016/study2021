package com.example.demo.algorithm;


/**
 * todo
 * date：2021/12/2  8:52 下午
 *
 * @author xuyy
 */
public class easy_226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //交换位置
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
