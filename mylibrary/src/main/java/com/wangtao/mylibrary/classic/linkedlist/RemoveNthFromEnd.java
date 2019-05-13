package com.wangtao.mylibrary.classic.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;

/**
 * @author wangtao
 * @Description: 删除链表中倒数第N个节点；给定的 n 保证是有效的
 * eg：给定一个链表: 1->2->3->4->5, 和 n = 2.当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @date 2019/5/13 16:02
 */
public class RemoveNthFromEnd {

    /**
     * 利用双指针，前后指针相差间隔为N
     *
     * @param head
     * @param n
     * @return
     */
    public static Node removeNthFromEnd(Node head, int n) {

        int i = 1;
        Node removeNode = head;
        Node curNode = head;
        Node preNode = null;

        while (curNode.next != null) {
            curNode = curNode.next;
            if (i == n || i++ >= n) {
                preNode = removeNode;
                removeNode = removeNode.next;
            }
        }
        //删除的是头结点
        if (removeNode == head) {
            head = head.next;
        }

        if (preNode != null) {
            preNode.next = removeNode.next;
        }

        return head;
    }
}
