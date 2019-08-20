package com.wangtao.mylibrary.algorithm.tree;

/**
 * @author wangtao
 * @Description: offer(24):输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 * @date 2019/8/20 9:35
 */
public class VerifySequenceOfBST {

    public static void main(String[] args) {
        VerifySequenceOfBST verifyer = new VerifySequenceOfBST();
        int[] data = {2, 1, 4, 5, 3, 7, 6, 9, 8};
        System.out.println("true: " + verifyer.verifySequenceOfBST(data));
    }

    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;

        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] sequence, int start, int end) {
        if (start >= end) return true;

        //获取数组最后一位，根节点
        int root = sequence[end];

        //用根节点划分,前半部分小于根节点；后半部分大于根节点
        int index = start;
        while (index < end - 1 && sequence[index] < root) {
            index++;
        }
        //index指向第一个大于root的下标
        // 判断后半部分是否满足条件
        int last = index;
        while (last < end - 1) {
            if (sequence[last] < root) return false;//后半部分有小于root的节点，返回false
            last++;
        }

        return verify(sequence, start, index - 1) && verify(sequence, index, end - 1);
    }
}
