package com.wangtao.mylibrary.datastructure.heap;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description:堆：①：完全二叉树；②：堆中每个节点的值都大于等于（小于等于）其左右子节点的值， 称为大顶堆（小顶堆）
 * @date 2019/2/12 14:16
 */
public class Heap {
    /**
     * 完全二叉树，适合用数组存储,下标从1开始存储数据（方便处理）
     */
    private int[] a;
    /**
     * 容量:存储的数据最大个数
     */
    private int capacity;
    /**
     * 已经存储的个数
     */
    private int count;

    public Heap(int capacity) {
        this.capacity = capacity;
        a = new int[capacity + 1];
    }

    /**
     * 第一种建堆的方法：插入数据，自下往上堆化
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= capacity) return;
        ++count;
        a[count] = data;
        int i = count;
        //自下往上堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            Utils.swap(a, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 删除堆顶数据，自上往下堆化
     */
    public void removeTop() {
        if (count == 0) return;
        int top = a[1];
        if (count == 1) {
            a[1] = -1;
        } else {
            //最后一节点数据，放到堆顶
            a[1] = a[count];
            a[count] = 0;
            --count;
            //自上往下堆化
            heapify(a, count, 1);
        }
    }

    public void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            Utils.swap(a, i, maxPos);
            i = maxPos;
        }
    }


    /**
     * 建堆的第二种方法：对每个非叶子节点进行自上而下堆化
     * 第一种：插入，自下而上的堆化
     *
     * @param a
     * @param n
     */
    public void buildHeap(int[] a, int n) {
        /**
         * 完全二叉树的特性：n/2+1 到 n都是 叶子节点，不需要堆化
         */
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }
}
