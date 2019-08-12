package com.wangtao.mylibrary.datastructure.linkedlist;

/**
 * @author wangtao
 * @Description: 链表节点
 * @date 2019/8/12 9:31
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
        }
        System.out.printf("[");
        while (head != null) {
            System.out.printf(head.val + "->");
            head = head.next;
        }

        System.out.printf("]");
        System.out.println();
    }

    public static ListNode createLinkedList(int n) {
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                tail = head = new ListNode(i);
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }
        return head;
    }
}
