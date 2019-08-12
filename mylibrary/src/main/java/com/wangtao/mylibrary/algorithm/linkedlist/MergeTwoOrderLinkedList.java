package com.wangtao.mylibrary.algorithm.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.ListNode;

/**
 * @author wangtao
 * @Description: offer(17):合并两个有序链表
 * @date 2019/5/13 14:41
 */

/**
 * 链表的基本操作；
 * 鲁棒性
 */
public class MergeTwoOrderLinkedList {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createLinkedList(3);
        ListNode l2 = ListNode.createLinkedList(5);

        MergeTwoOrderLinkedList merger = new MergeTwoOrderLinkedList();
        ListNode node = merger.Merge(l1, l2);
        ListNode.printList(node);

    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode tail = null;

        while (list1 != null && list2 != null) {
            ListNode next = null;
            //找到两个链表中较小值节点
            if (list1.val < list2.val) {
                next = list1;
                list1 = list1.next;
            } else {
                next = list2;
                list2 = list2.next;
            }
            //插入链表
            if (head == null) {//头结点
                tail = head = next;
            } else {
                tail.next = next;
                tail = tail.next;
            }
        }
        //剩余的部分
        tail.next = list1 == null ? list2 : list1;

        return head;
    }
}
