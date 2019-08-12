package com.wangtao.mylibrary.algorithm.tree;

/**
 * @author wangtao
 * @Description: offer(18):输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @date 2019/8/12 11:37
 */

import com.wangtao.mylibrary.datastructure.tree.TreeNode;

/**
 * 对二叉树的理解和操作
 * 递归
 */
public class SubTree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;//空树不是任意一个树的子结构
        if (root1 == null) return false;
        if (root1 == root2) return true;//同一个节点，直接返回true

        boolean result = false;
        //当前节点值相同，匹配剩余节点的值
        if (root1.val == root2.val) {
            result = match(root1, root2);
        }
        //所有节点值都匹配成功，返回true
        if (result) {
            return true;
        }
        //当前节点匹配不成功，再看左右子树是否匹配成功
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean match(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;
        if (root1 == null) return false;

        if (root1.val == root2.val) {
            //如果已经匹配root2的叶子节点，说明匹配成功
            return (root2.left == null || match(root1.left, root2.left)) && (root2.right == null || match(root1.right, root2.right));
        }

        return false;
    }
}
