package com.wangtao.mylibrary.algorithm.tree;

import com.wangtao.mylibrary.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @Description: offer(25):
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @date 2019/8/20 15:25
 */
public class FindPath {

    public static void main(String[] args) {
        FindPath finder = new FindPath();

        //            10
        //         /      \
        //        5        12
        //       /\        /
        //      7  7     -1
        //     /
        //    -1
        //    /
        //   1
        TreeNode root = new TreeNode();
        root.val = 10;
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(-1);
        System.out.println("findPath(root, 22);");
        finder.findPath(root, 22);
    }

    public void findPath(TreeNode root, int target) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (root != null) {
            findPath(root, 0, target, nodeList);
        }
    }

    /**
     * 需要考虑负值的情况
     *
     * @param curNode
     * @param cur
     * @param target
     * @param list
     */
    public void findPath(TreeNode curNode, int cur, int target, List<TreeNode> list) {
        if (curNode != null) {
            //加上当前节点的值
            cur += curNode.val;
            //当前节点入队列
            list.add(curNode);
            //如果值与目标值不相等或者不是叶子节点，取左/右节点继续比较
            if (cur != target || curNode.left != null || curNode.right != null) {
                findPath(curNode.left, cur, target, list);//①
                findPath(curNode.right, cur, target, list);//②
            } else {
                //如果相等,并且当前节点是叶子节点，输出结果
                for (TreeNode node : list) {
                    System.out.print(node.val + " ");
                }
                System.out.println();
            }
            //删除当前节点，相当于退回到上一层，换成右节点（②）继续递归
            list.remove(list.size() - 1);
        }
    }
}
