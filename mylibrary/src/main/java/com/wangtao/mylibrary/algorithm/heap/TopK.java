package com.wangtao.mylibrary.algorithm.heap;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description: 堆应用:（TopK）求前K大的数值
 * @date 2019/7/2 14:36
 */
public class TopK {

    private int[] mHeap;
    private int mCount;

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 10, 1, 20, 13};
        TopK.topK(arr, 5);
        TopK topK = new TopK(5);
        System.out.println();
        for (int i : arr) {
            topK.add(i);
        }
        printHeap(topK.getTopK());
    }

    public TopK(int k) {
        mHeap = new int[k + 1];
    }

    public void add(int value) {
        insert(mHeap, value, ++mCount);
    }

    public int[] getTopK() {
        return mHeap;
    }

    /**
     * 静态数据中获取前K大的值
     *
     * @param arr
     * @param k
     */
    public static void topK(int[] arr, int k) {
        int[] heap = new int[k + 1];
        for (int i = 0; i < arr.length; i++) {
            insert(heap, arr[i], i + 1);
        }

        printHeap(heap);
    }

    private static void printHeap(int[] heap) {
        for (int i = 1; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
    }


    private static void insert(int[] heap, int value, int count) {
        if (count > heap.length - 1) {
            int top = heap[1];
            if (value > top) {
                heap[1] = value;
                heapifyUp2Down(heap, heap.length - 1, 1);
            }
        } else {
            heap[count] = value;
            heapifyDown2Up(heap, count);
        }
    }

    private static void heapifyUp2Down(int[] heap, int count, int i) {
        while (true) {
            int m = i;
            if (i * 2 <= count && heap[i] > heap[i * 2]) m = i * 2;
            if (i * 2 + 1 <= count && heap[m] > heap[i * 2 + 1]) m = i * 2 + 1;
            if (m == i) break;
            Utils.swap(heap, i, m);
            i = m;
        }
    }

    private static void heapifyDown2Up(int[] heap, int count) {
        int i = count;
        while (i / 2 >= 1 && heap[i / 2] > heap[i]) {
            Utils.swap(heap, i, i / 2);
            i = i / 2;
        }
    }
}
