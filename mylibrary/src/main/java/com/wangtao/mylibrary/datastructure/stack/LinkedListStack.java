package com.wangtao.mylibrary.datastructure.stack;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;

/**
 * @author wangtao
 * @Description: 链式栈
 * @date 2019/6/4 16:09
 */
public class LinkedListStack<Data> {

    Node<Data> top;//栈顶

    /**
     * 压栈
     * @param data
     */
    public void push(Data data) {
        Node<Data> newNode = new Node<>(data);
        if (top == null) {
            top = newNode;
        } else {//头插法
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 弹栈
     * @return
     */
    public Data pop() {
        if (null == top) return null;//空栈
        Data data = top.value;
        top = top.next;
        return data;
    }
}
