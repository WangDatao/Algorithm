package com.wangtao.mylibrary.datastructure.queue;


/**
 * @author wangtao
 * @Description: 环形队列
 * @date 2019/6/4 14:08
 */
public class CircularQueue {
    private Object[] items;
    private int capacity;

    private int head = 0;
    private int tail = 0;


    public CircularQueue(int capacity) {
        items = new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * 出队
     *
     * @return
     */
    public Object dequeue() {
        if (head == tail) return null;
        Object result = items[head];
        head = (head + 1) % capacity;
        return result;
    }

    /**
     * 入队
     *
     * @param data
     */
    public boolean enqueue(Object data) {
        if ((tail + 1) % capacity == head) return false;//这里（tail+1）% capacity == head，导致最后tail位置无法存储数据，少存储一个数据。
        items[tail] = data;
        tail = (tail + 1) % capacity;
        return true;
    }


}
