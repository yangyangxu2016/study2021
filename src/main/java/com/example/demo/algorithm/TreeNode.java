package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 * date：2021/11/28  3:01 下午
 *
 * @author xuyy
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public int maxDepth(TreeNode root) {
        int res =0;
        int depth =0;
        maxDepth(root,res,depth);
        return res;
    }

    public void maxDepth(TreeNode root,int res,int depth) {
        if(root == null){
            res = Math.max(res,depth);
        }
        depth++;
        maxDepth(root.left,res,depth);
        maxDepth(root.right,res,depth);
        depth--;

    }
}
