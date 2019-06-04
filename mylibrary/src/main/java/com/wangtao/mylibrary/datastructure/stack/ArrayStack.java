package com.wangtao.mylibrary.datastructure.stack;

/**
 * @author wangtao
 * @Description: 顺序栈
 * @date 2019/6/4 16:15
 */
public class ArrayStack {
    private Object[] items;
    private int capacity;
    private int count;

    public ArrayStack(int capacity) {
        items = new Object[capacity];
        this.capacity = capacity;
    }

    public boolean push(Object data) {
        if (capacity == count) return false;
        items[count++] = data;
        return true;
    }

    public Object pop() {
        if (count == 0) return null;
        Object data = items[count - 1];
        count--;
        return data;
    }
}
