package com.wangtao.mylibrary.algorithm.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.ListNode;

/**
 * @author wangtao
 * @Description: offer(16):单链表翻转
 * @date 2019/4/19 16:23
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        ReverseLinkedList list = new ReverseLinkedList();

        ListNode head = ListNode.createLinkedList(5);
        ListNode.printList(list.reverse(head));
    }

    private static void test2() {
        ReverseLinkedList list = new ReverseLinkedList();

        ListNode head = ListNode.createLinkedList(10);
        list.reverseByRecursive(head);
        ListNode.printList(list.newHead);
    }

    /**
     * 循环方式
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        //空链表或者只有一个节点
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode nn = next.next;
            next.next = cur;
            cur = next;
            next = nn;
        }
        //原链表头节点，现在变成了尾节点，next指针需要置空
        head.next = null;
        //cur节点是原链表的尾节点，现在变成头节点
        head = cur;
        return head;
    }

    public ListNode newHead;

    public void reverseByRecursive(ListNode head) {
        if (head == null || head.next == null) return;

        reverseFrom(head);
        head.next = null;
    }

    private ListNode reverseFrom(ListNode from) {
        if (from.next != null) {
            ListNode next = reverseFrom(from.next);
            next.next = from;
        } else {
            newHead = from;
        }
        return from;
    }


}
