package com.wangtao.mylibrary.datastructure.heap;

/**
 * @author wangtao
 * @Description:
 * @date 2019/7/2 10:39
 */
public class HeapAny<T extends Comparable> {
    private Object[] items;

    private int capacity;

    private int count;

    private boolean smallTop;//小顶堆还是大顶堆

    public HeapAny(int capacity) {
        this(capacity, false);
    }

    public HeapAny(int capacity, boolean smallTop) {
        this.capacity = capacity;
        this.smallTop = smallTop;
        items = new Object[capacity + 1];//从下标1开始
    }

    /**
     * 注意： 数组需要从下标1开始存储数据
     *
     * @param arr
     */
    public void buildHeap(T[] arr, int n) {
        //非叶子节点开始堆化
        for (int i = arr.length / 2; i >= 1; i--) {
            heapify(arr, n, i);
        }
    }

    public boolean insert(T item) {
        if (count == capacity) return false;
        items[++count] = item;
        int i = count;
        while (i / 2 >= 1 && needSwap(items, i / 2, i)) {
            swap(items, i / 2, i);
            i = i / 2;
        }
        return true;
    }

    public T pop() {
        if (count == 0)
            return null;
        T item = (T) items[1];
        if (count == 1) {
            items[1] = null;
            count--;
        } else {
            items[1] = items[count];
            items[count] = null;
            count--;
            heapify(items, count, 1);
        }
        return item;
    }

    /**
     * 之上而下堆化
     *
     * @param arr
     * @param n
     * @param i
     */
    public void heapify(Object[] arr, int n, int i) {
        while (true) {
            int m = i;//min or max index
            if (i * 2 <= n && needSwap(arr, i, i * 2)) m = i * 2;
            if (i * 2 + 1 <= n && needSwap(arr, m, i * 2 + 1)) m = i * 2 + 1;
            if (i == m) break;
            swap(arr, i, m);
            i = m;
        }
    }

    private void swap(Object[] arr, int a, int b) {
        Object t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    private boolean needSwap(Object[] arr, int f, int t) {
        return smallTop ? ((Comparable) arr[f]).compareTo(arr[t]) > 0 : ((Comparable) arr[f]).compareTo(arr[t]) < 0;
    }

}
