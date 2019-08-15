package com.wangtao.mylibrary.algorithm.tree;

/**
 * @author wangtao
 * @Description: offer(23)：从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
 * @date 2019/8/15 14:15
 */

import com.wangtao.mylibrary.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 其实就是二叉树的层序遍历
 */
public class PrintByFloor {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        PrintByFloor print = new PrintByFloor();
        ArrayList<Integer> result = print.PrintFromTopToBottom(root);
        for (Integer i : result) {
            System.out.print(i);
        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //结果
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            //队列
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                //每一层的个数
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    result.add(node.val);
                    if (null != node.left) queue.add(node.left);
                    if (null != node.right) queue.add(node.right);
                }
            }
        }
        return result;
    }
}
