package com.wangtao.mylibrary.algorithm.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.ListNode;

/**
 * offer(15):获取链表倒数第K个节点的值
 *
 * ①链表的基本操作，“双指针”
 * ②鲁棒性，各种特殊情况的处理
 */
public class GetNthFromEnd {


    public static void main(String[] args) {
        GetNthFromEnd getter = new GetNthFromEnd();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < 1; i++) {
            if (head == null) {
                tail = head = new ListNode(i);
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }

        ListNode listNode = getter.FindKthToTail(head, 2);

        System.out.println(listNode != null ? listNode.val + "" : "null");
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        //空链表、k值不合法
        if (head == null || k <= 0) {
            return null;
        }

        ListNode target = head;
        ListNode ahead = head;
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
            } else {// 链表长度不足k个节点，直接返回null
                return null;
            }
        }
        //target节点和ahead节点保持k-1个距离，直到ahead节点指向尾节点
        while (ahead.next != null) {
            target = target.next;
            ahead = ahead.next;
        }

        return target;
    }
}
