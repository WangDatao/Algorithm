package com.wangtao.mylibrary.datastructure.tree;

/**
 * @author wangtao
 * @Description: 打印二叉树的工具类
 * @date 2019/8/8 16:54
 */
public class PrintTree {


    public static void prePrint(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            prePrint(node.left);
            prePrint(node.right);

        }
    }


    public static void midPrint(TreeNode node) {
        if (node != null) {
            midPrint(node.left);
            System.out.print(node.value + " ");
            midPrint(node.right);
        }
    }

    public static void aftPrint(TreeNode node) {
        if (node != null) {
            aftPrint(node.left);
            aftPrint(node.right);
            System.out.print(node.value + " ");
        }
    }
}
