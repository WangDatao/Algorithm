package com.wangtao.mylibrary.datastructure.tree;

/**
 * @author wangtao
 * @Description:二叉树节点
 * @date 2019/3/13 14:12
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
