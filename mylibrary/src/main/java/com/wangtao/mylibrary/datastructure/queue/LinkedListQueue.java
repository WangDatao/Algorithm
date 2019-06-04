package com.wangtao.mylibrary.datastructure.queue;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;

/**
 * @author wangtao
 * @Description: 链表实现的队列
 * @date 2019/6/4 15:47
 */
public class LinkedListQueue<Data> {
    Node<Data> head;
    Node<Data> tail;

    public boolean enqueue(Data data) {
        Node<Data> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        return true;
    }

    public Data dequeue() {
        if (head == null) return null;
        Data data = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}
