package com.example.demo.algorithm;


import org.apache.naming.EjbRef;

/**
 * todo
 * date：2021/12/2  8:52 下午
 *
 * @author xuyy
 */
public class easy_226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
    //    bsse
        if (root == null) {
            return root;
        }

        //交换左右
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
