package com.wangtao.mylibrary.algorithm.tree;

import com.wangtao.mylibrary.datastructure.tree.PrintTree;
import com.wangtao.mylibrary.datastructure.tree.TreeNode;

/**
 * @author wangtao
 * @Description: offer(19):操作给定的二叉树，将其变换为源二叉树的镜像。
 * @date 2019/8/12 14:44
 */

/**
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */

/**
 * 二叉树的基本操作
 * 前序遍历
 * 递归
 */
public class MirrorTree {

    public static void main(String[] args) {
        MirrorTree mirrorTree = new MirrorTree();
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(6);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        PrintTree.prePrint(root);
        System.out.println();
        mirrorTree.Mirror(root);
        PrintTree.prePrint(root);
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;

        if (root.left != null || root.right != null) {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            node = null;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
