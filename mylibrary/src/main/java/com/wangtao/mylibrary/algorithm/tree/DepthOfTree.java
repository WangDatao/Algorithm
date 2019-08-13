package com.wangtao.mylibrary.algorithm.tree;

import com.wangtao.mylibrary.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtao
 * @Description: offer(39):二叉树的深度
 * @date 2019/8/13 11:39
 */
public class DepthOfTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DepthOfTree depth = new DepthOfTree();

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);

        int d = depth.getDepth(root);
        System.out.println();
        System.out.print(d);
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public int getDepthByFloor(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点加入队列
        queue.add(root);
        //广度
        int maxWidth = 0;
        //深度
        int depth = 0;

        while (queue.size() != 0) {
            int size = queue.size();
            maxWidth = Math.max(size, maxWidth);
            int cur = 0;
            while (cur < size) {
                TreeNode node = queue.remove();
                System.out.print(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                cur++;
            }
            depth++;
        }

        return depth;
    }
}
