package com.wangtao.mylibrary.datastructure.queue;

/**
 * @author wangtao
 * @Description: 数组实现的队列
 * @date 2019/6/4 11:34
 */
public class ArrayQueue {
    private Object[] items;
    private int capacity;

    private int head = 0;
    private int tail = 0;


    public ArrayQueue(int capacity) {
        items = new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队
     *
     * @param data
     * @return
     */
    public boolean enqueue(Object data) {
        if (tail == capacity) {
            if (head == 0) {//队列满了
                return false;
            } else {//队列未满，移动
                for (int i = head; i < tail; i++) {
                    items[i - head] = items[i];
                }
                tail = tail - head;
                head = 0;
            }
        }
        items[tail] = data;
        tail++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public Object dequeue() {
        if (head == tail) return null;
        return items[head++];
    }
}
