package com.wangtao.mylibrary.classic;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;

/**
 * @author wangtao
 * @Description:单链表翻转
 * @date 2019/4/19 16:23
 */
public class ReverseLinkedList<Data> {

    public Node<Data> head, tail;

    public ReverseLinkedList(Data... values) {
        for (Data value : values) {
            if (head == null) {
                head = tail = new Node<>(value);
            } else {
                Node<Data> node = new Node<>(value);
                tail.next = node;
                tail = node;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node cur = head;

        while (cur != null) {
            builder.append(cur.value)
                    .append(" ");
            cur = cur.next;
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * 循环迭代
     *
     * @return
     */
    public ReverseLinkedList<Data> reverseByLoop() {
        //空链表或者单元素，无需改变
        if (head == tail) return this;

        Node<Data> cur = head;
        Node<Data> next = cur.next;

        while (next != null) {
            Node<Data> nextNext = next.next;

            next.next = cur;
            cur = next;
            next = nextNext;
        }
        //处理下head tail
        tail = head;
        head.next = null;
        head = cur;

        return this;
    }

    public ReverseLinkedList<Data> reversByRecursive() {
        if (head == tail) return this;
        Node<Data> oldTail = tail;
        tail = reverseFrom(head);
        tail.next =null;
        head = oldTail;

        return this;
    }

    private Node<Data> reverseFrom(Node<Data> from) {
        if (from == tail) return from;
        Node<Data> end = reverseFrom(from.next);
        end.next = from;
        return from;
    }

}
