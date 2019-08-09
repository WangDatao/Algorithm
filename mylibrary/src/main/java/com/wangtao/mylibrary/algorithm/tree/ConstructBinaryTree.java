package com.wangtao.mylibrary.algorithm.tree;

import com.wangtao.mylibrary.datastructure.tree.PrintTree;
import com.wangtao.mylibrary.datastructure.tree.TreeNode;

/**
 * @author wangtao
 * @Description: offer<6>:给定二叉树的前序遍历和中序遍历数组，重建二叉树</>
 * @date 2019/8/8 16:19
 */
public class ConstructBinaryTree {


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length || pre.length == 0) {
            return null;
        }

        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 构建二叉树：利用前序遍历的节点（根节点），在中序遍历的划分出左右子树，递归
     *
     * @param pre 前序遍历数组
     * @param ps  前序遍历开始下标
     * @param pe  前序遍历结束下标
     * @param in  中序遍历数组
     * @param is  中序遍历开始下标
     * @param ie  中序遍历结束下标
     * @return 构建完成二叉树的根节点
     */
    private static TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {

        if (ps > pe) {
            return null;
        }
        //前序遍历的第一个数字，是当前树的根节点
        int rootValue = pre[ps];

        //中序遍历中找到根节点的下标，划分左右子树
        int index = is;
        while (index <= ie) {
            if (in[index] == rootValue) break;
            index++;
        }
        if (index > ie) {
            throw new IllegalArgumentException("输入的前序\\中序遍历数组是错误的");
        }
        //创建当前子树的根节点
        TreeNode rootNode = new TreeNode(rootValue);
        //递归构建左子树
        rootNode.left = construct(pre, ps + 1, ps + (index - is), in, is, index - 1);
        //递归构建右子树
        rootNode.right = construct(pre, ps + (index - is) + 1, pe, in, index + 1, ie);

        //左右子树的前序遍历开始结束下标，注意

        //返回创建的根节点
        return rootNode;
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       7
    //         / \      / \
    //        3   4    10   9
    //       /   /      \
    //      8   6        11
    private static void test1() {
        int[] preorder = {1, 2, 3, 8, 4, 6, 7, 10, 11, 9};
        int[] inorder = {8, 3, 2, 6, 4, 1, 10, 11, 7, 9};
        TreeNode rootNode = reConstructBinaryTree(preorder, inorder);
        PrintTree.prePrint(rootNode);
        System.out.println();
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        TreeNode rootNode = reConstructBinaryTree(preorder, inorder);
        PrintTree.prePrint(rootNode);
        System.out.println();
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //

    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        TreeNode rootNode = reConstructBinaryTree(preorder, inorder);
        PrintTree.prePrint(rootNode);
        System.out.println();
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {5};
        int[] inorder = {5};
        TreeNode rootNode = reConstructBinaryTree(preorder, inorder);
        PrintTree.prePrint(rootNode);
        System.out.println();
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        PrintTree.prePrint(root);
        System.out.println();
    }

    // 输入空指针
    private static void test6() {
        reConstructBinaryTree(null, null);
        System.out.println();
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        PrintTree.prePrint(root);
        System.out.println();
    }

}
