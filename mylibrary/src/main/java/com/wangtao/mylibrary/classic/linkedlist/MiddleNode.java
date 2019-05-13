package com.wangtao.mylibrary.classic.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;

/**
 * @author wangtao
 * @Description: 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 * @date 2019/5/13 16:46
 */
public class MiddleNode {
    /**
     * 快慢双指针
     *
     * @param head
     * @return
     */
    public static Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast.next == null ? slow : slow.next;
    }
}
