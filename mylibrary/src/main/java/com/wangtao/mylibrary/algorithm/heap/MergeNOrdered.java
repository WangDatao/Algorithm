package com.wangtao.mylibrary.algorithm.heap;

import android.support.annotation.NonNull;

import com.wangtao.mylibrary.Utils;
import com.wangtao.mylibrary.datastructure.linkedlist.Node;

/**
 * @author wangtao
 * @Description: 堆应用(优先级队列)：合并N个有序小文件
 * @date 2019/7/1 11:27
 */
public class MergeNOrdered {

    public static final int SUB_LENGTH = 5;
    public static final int[] arr1 = new int[SUB_LENGTH];
    public static final int[] arr2 = new int[SUB_LENGTH];

    public static final int[] result = new int[SUB_LENGTH * 2];

    static {
        for (int i = 0; i < SUB_LENGTH * 2; i += 2) {
            arr1[i / 2] = i;
            arr2[i / 2] = i + 1;
        }
    }

    /**
     * 每次获取N个数组中最小的数，插入result。
     * 这里N为2，可以直接比较(时间复杂度为O(n))，不用小顶堆。
     * 类似归并排序
     */
    public static void merge() {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < SUB_LENGTH && j < SUB_LENGTH) {
            if (arr1[i] < arr2[j]) {
                result[count++] = arr1[i];
                i++;
            } else {
                result[count++] = arr2[j];
                j++;
            }
        }

        for (; i < SUB_LENGTH; i++) {
            result[count++] = arr1[i];
        }
        for (; j < SUB_LENGTH; j++) {
            result[count++] = arr2[j];
        }

        Utils.printArr(result);
    }

    /**
     * 但是如果N的比较大，利用小顶堆，插入时的时间复杂度为O(logn)
     */
    private static int heapCount = 0;

    public static void mergeByHeap(int[]... orderedArr) {

        Node<Integer> head = null;
        Node<Integer> tail = null;

        /**
         * 有N个需要合并的数组，heapArr的大小就为N
         */
        HeapNode[] heapArr = new HeapNode[orderedArr.length + 1];

        //初始化,取出每个数组中的第一个
        for (int j = 0; j < orderedArr.length; j++) {
            int[] arr = orderedArr[j];
            heapArr[++heapCount] = new HeapNode(arr[0], 0, j);
        }
        //构建小顶堆
        buildSmallTopHeap(heapArr, heapCount);
        //取出堆顶节点
        while (true) {
            HeapNode node = getHeapNode(heapArr, orderedArr);
            if (node == null) break;
            //加入到链表中
            if (head == null) {
                head = tail = new Node<>(node.value);
            } else {
                tail.next = new Node<>(node.value);
                tail = tail.next;
            }
        }
        StringBuilder builder = new StringBuilder();
        Node cursor = head;
        while (cursor != null) {
            builder.append(cursor.value).append(" ");
            cursor = cursor.next;
        }
        System.out.printf(builder.toString());

    }

    @NonNull
    private static HeapNode getHeapNode(HeapNode[] heapArr, int[][] orderedArr) {
        if (heapCount < 1) {
            return null;
        }
        HeapNode node = heapArr[1];

        //获取数组
        int[] arr = orderedArr[node.arrIndex];
        int nextIndex = node.index + 1;
        //当前节点是数组中的最后一个
        if (nextIndex > arr.length - 1) {
            //把堆中最后一个节点放到堆顶
            heapArr[1] = heapArr[heapCount];
            heapArr[heapCount] = null;
            heapCount--;
        } else {
            //下一个数值
            int value = arr[nextIndex];
            //替换
            heapArr[1] = new HeapNode(value, nextIndex, node.arrIndex);
        }

        //堆化
        heapify(heapArr, heapCount, 1);
        return node;
    }

    /**
     * 构建小顶堆
     *
     * @param arr 数组
     * @param n   数组长度
     */
    public static void buildSmallTopHeap(HeapNode[] arr, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, heapCount, i);
        }
    }

    /**
     * 对第i个节点之上而下的堆化
     *
     * @param arr 数组
     * @param n   数组的长度
     * @param i   堆化的节点
     */
    public static void heapify(HeapNode[] arr, int n, int i) {
        while (true) {
            int minPos = i;
            if (i * 2 <= n && HeapNode.compare(arr, i, i * 2)) minPos = i * 2;
            if (i * 2 + 1 <= n && HeapNode.compare(arr, minPos, i * 2 + 1)) minPos = i * 2 + 1;
            if (minPos == i) break;
            HeapNode.swap(arr, i, minPos);
            i = minPos;
        }
    }

    /**
     * 插入节点并且堆化
     *
     * @param arr
     */
    public static void insertAndHeapify(HeapNode[] arr, HeapNode node) {
        arr[++heapCount] = node;
        int i = heapCount;
        while (i / 2 > 0 && HeapNode.compare(arr, i / 2, i)) {
            HeapNode.swap(arr, i / 2, i);
            i = i / 2;
        }
    }


    /**
     * 辅助节点
     */
    public static class HeapNode {
        public int value;
        public int index;//节点值在数组中的位置
        public int arrIndex;//节点所在数组在数组中的位置

        public HeapNode(int value, int index, int arrIndex) {
            this.value = value;
            this.index = index;
            this.arrIndex = arrIndex;
        }

        public static boolean compare(HeapNode[] arr, int indexA, int indexB) {
            return arr[indexA].value > arr[indexB].value;
        }

        public static void swap(HeapNode[] arr, int indexA, int indexB) {
            HeapNode node = arr[indexA];
            arr[indexA] = arr[indexB];
            arr[indexB] = node;
        }
    }
}
