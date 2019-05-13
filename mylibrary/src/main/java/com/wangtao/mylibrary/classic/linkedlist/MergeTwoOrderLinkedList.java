package com.wangtao.mylibrary.classic.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;

/**
 * @author wangtao
 * @Description: 合并两个有序链表
 * @date 2019/5/13 14:41
 */
public class MergeTwoOrderLinkedList {

    public static Node<Integer> mergeTwoList(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> head = null;
        Node<Integer> tail = null;

        if (null == l1) return l2;
        if (null == l2) return l1;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                if (head == null) {
                    head = tail = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l1;
                    tail = l1;
                    l1 = l1.next;
                }
            } else {
                if (head == null) {
                    head = tail = l2;
                    l2 = l2.next;
                } else {
                    tail.next = l2;
                    tail = l2;
                    l2 = l2.next;
                }
            }

        }

        if (null != l1) {
            tail.next = l1;
        } else if (null != l2) {
            tail.next = l2;
        }

        return head;
    }
}
