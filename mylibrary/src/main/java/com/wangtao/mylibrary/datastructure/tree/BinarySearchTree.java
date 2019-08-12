package com.wangtao.mylibrary.datastructure.tree;

/**
 * @author wangtao
 * @Description:二叉查找树：插入、删除、和查找时间复杂度-O(logn)
 * @date 2019/3/13 14:19
 * <p>
 * 特点：
 * 1.任意节点的左子节点的值都小于这个节点的值；右子节点的值都大于这个节点的值;
 * 2.中序遍历可以得到有序的数据序列
 * 3.支持插入、删除、查找；支持快速查找最大和最小节点，前驱和后继节点
 * <p>
 * 和散列表相比：
 * 1.散列表无序
 * 2.散列表扩容，耗时；散列冲突，性能不稳定；
 * 3.尽管散列表的插入、查找、删除操作时间复杂度是常量级，但是散列冲突的存在，实际速度可能不一定高
 * 4.散列表构造复杂：hash函数的设计、冲突解决、扩容、缩容
 */


/**
 * 未考虑节点值重复的情况:
 * 解决办法：1.同一个节点存储多个值重复-用链表；2.重复值得节点添加在右子树中
 */
public class BinarySearchTree {

    public TreeNode tree;

    public TreeNode search(int value) {
        TreeNode p = tree;
        while (p != null) {
            if (p.val == value) return p;
            if (p.val > value) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * @param value
     */
    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (tree == null) {//插入根节点
            tree = node;
            return;
        }
        TreeNode p = tree;

        while (p != null) {
            if (p.val > value) {
                if (p.left == null) {
                    p.left = node;
                    return;
                }
                p = p.left;

            } else {
                if (p.right == null) {
                    p.right = node;
                    return;
                }
                p = p.right;
            }
        }

    }

    /**
     * 删除的节点三种情况：
     * 1.没有子节点——直接从父节点中删除指向节点的指针
     * 2.只有一个子节点——更新父节点指向删除节点的指针，让其指向删除节点的子节点
     * 3.有两个子节点——从右子树中找到最小的节点，替换到要删除的节点上。再删除这个最小节点，最小
     * 节点没有左子树。再按上面1、2的方法删除最小节点
     *
     * @param value
     */
    public void delete(int value) {
        TreeNode p = tree;
        TreeNode pre = null;
        TreeNode result = null;
        //查找要删除的节点
        while (p != null && p.val != value) {
            if (p.val > value) {
                p = p.left;
                pre = p;
            } else if (p.val < value) {
                p = p.right;
                pre = p;
            }
        }
        //未找到
        if (null == p) return;
        //两个子节点
        if (p.left != null && p.right != null) {
            //有子树中找到最小的节点
            TreeNode minP = p.right;
            TreeNode minPre = p;
            while (minP.left != null) {
                minPre = minP;
                minP = minP.left;
            }
            //赋值
            p.val = minP.val;
            //将要删除的指针指向，minP
            p = minP;
            pre = minPre;
        }
        //此时，删除p指向的节点;p指向的节点要么没有子节点，要么只有一个子节点
        TreeNode child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pre == null) {//删除的是根节点
            tree = child;
        } else if (pre.left == p) {
            pre.left = child;
        } else {
            pre.right = child;
        }
    }
}
