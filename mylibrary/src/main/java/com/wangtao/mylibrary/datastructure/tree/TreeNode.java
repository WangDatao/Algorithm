package com.wangtao.mylibrary.datastructure.tree;

/**
 * @author wangtao
 * @Description:二叉树节点
 * @date 2019/3/13 14:12
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
