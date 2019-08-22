package com.wangtao.mylibrary.algorithm.tree;


/**
 * @author wangtao
 * @Description: offer(27): 二叉搜索树转换成双向链表
 * @date 2019/8/21 11:06
 */
public class ConvertTreeToList {
    //           4
    //        /     \
    //       2       6
    //     /   \    /   \
    //    1    3   5     7

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        ConvertTreeToList converter = new ConvertTreeToList();
        TreeNode head = converter.convert(root);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.right;
        }
    }

    public TreeNode convert(TreeNode root) {
        if (root == null) return null;
        //lastNode 是双向链表的最后一个节点
        TreeNode lastNode = convertNode(root, null);
        //找到第一个节点
        while (lastNode != null && lastNode.left != null) {
            lastNode = lastNode.left;
        }
        return lastNode;
    }

    /**
     * 利用一个指针，指向已经链表化部分的最后一个节点
     *
     * @param node     当前节点
     * @param lastNode 指向最后的节点指针
     * @return
     */
    public TreeNode convertNode(TreeNode node, TreeNode lastNode) {
        if (node == null) return null;
        TreeNode cur = node;
        //中序遍历
        if (node.left != null) {
            lastNode = convertNode(node.left, lastNode);//对左子树进行链表化，返回最后一个节点
        }
        //当前节点的左指针，指向最后节点
        cur.left = lastNode;
        //如果最后节点不为空，最后节点右指针指向当前节点
        if (lastNode != null) {
            lastNode.right = cur;
        }
        //左子树以及当前节点已经链表化完成，移动最后节点指向当前节点
        lastNode = cur;
        //开始右子树的链表化
        if (cur.right != null) {
            lastNode = convertNode(cur.right, lastNode);
        }
        return lastNode;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
