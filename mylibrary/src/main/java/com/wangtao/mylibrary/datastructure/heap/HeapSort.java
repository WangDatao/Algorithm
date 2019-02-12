package com.wangtao.mylibrary.datastructure.heap;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description:堆排序:①：堆顶元素与最后一位元素交换；②：从堆顶开始堆化
 * @date 2019/2/12 15:52
 */
public class HeapSort {
    /**
     * @param a 数组中数据从下标1开始到n
     * @param n
     */
    public static void sort(int[] a, int n) {
        Heap heap = new Heap(n);
        //先建堆O(n)
        heap.buildHeap(a, n);
        int count = n;
        while (count > 1) {
            Utils.swap(a, count, 1);
            --count;
            heap.heapify(a, count, 1);
        }
    }
}
