package com.wangtao.mylibrary.algorithm.heap;

import com.wangtao.mylibrary.Utils;

import java.util.ArrayList;

/**
 * @author wangtao
 * @Description: offer(29)-堆应用（TOP K）:输入n个整数，找出其中最小的k个数。
 * @date 2019/7/2 14:36
 */
public class TopK {

    public static void main(String[] args) {
        int[] arr = {2, 4, 14, 7, 5, 10, 1, 20, 13};
        testHeapMethod(arr, arr.length);
        System.out.println();
        testPartMethod(arr, arr.length);
    }

    private static void testPartMethod(int[] arr, int k) {
        if (k < 0 || k > arr.length) return;
        partMethod(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void testHeapMethod(int[] arr, int k) {
        if (arr == null || k < 0 || k > arr.length) return;
        //求出top k的堆
        int[] resultHeap = topK(arr, k);
        //堆排序
        for (int i = resultHeap.length - 1; i >= 1; i--) {
            Utils.swap(resultHeap, 1, i);
            heapifyUp2Down(resultHeap, i - 1, 1);
        }
        for (int i = 1; i < resultHeap.length; i++) {
            System.out.print(resultHeap[i] + " ");
        }
    }


    public static int[] topK(int[] arr, int k) {
        //维护一个大顶堆
        int[] heap = new int[k + 1];
        //遍历所有数据
        for (int i = 0; i < arr.length; i++) {
            insert(heap, arr[i], i + 1);
        }
        return heap;
    }

    private static void insert(int[] heap, int value, int count) {
        if (count > heap.length - 1) {//堆已满
            int top = heap[1];
            //如果插入值小于堆顶
            if (value < top) {
                //替换堆顶
                heap[1] = value;
                //从上往下堆化
                heapifyUp2Down(heap, heap.length - 1, 1);
            }
        } else {
            //堆未满，直接插入数据到末尾
            heap[count] = value;
            //从下往上堆化
            heapifyDown2Up(heap, count);
        }
    }

    /**
     * 从上往下堆化
     *
     * @param heap
     * @param count
     * @param i
     */
    private static void heapifyUp2Down(int[] heap, int count, int i) {
        while (true) {
            int m = i;
            if (i * 2 <= count && heap[i] < heap[i * 2]) m = i * 2;
            if (i * 2 + 1 <= count && heap[m] < heap[i * 2 + 1]) m = i * 2 + 1;
            if (m == i) break;
            Utils.swap(heap, i, m);
            i = m;
        }
    }

    /**
     * 从下往上堆化
     *
     * @param heap
     * @param count
     */
    private static void heapifyDown2Up(int[] heap, int count) {
        int i = count;
        while (i / 2 >= 1 && heap[i / 2] < heap[i]) {
            Utils.swap(heap, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 打印
     *
     * @param heap
     */
    private static void printHeap(int[] heap) {
        for (int i = 1; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    /**
     * 快排思想,找到第K大的数值，适用于数据量较小的情况
     *
     * @param arr
     * @param k
     */
    private static void partMethod(int[] arr, int start, int end, int k) {
        if (k > end + 1 || k < 0) return;
        int p = part(arr, start, end);
        if (p == k - 1) {
            return;
        } else if (p > k - 1) {
            partMethod(arr, start, p - 1, k);
        } else {
            partMethod(arr, p + 1, end, k);
        }
    }

    private static int part(int arr[], int start, int end) {
        int point = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < point) {
                if (i != j) {
                    Utils.swap(arr, i, j);
                }
                i++;
            }
        }
        Utils.swap(arr, i, end);
        return i;
    }
}
