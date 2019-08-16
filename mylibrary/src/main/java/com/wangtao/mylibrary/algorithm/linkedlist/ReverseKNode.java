package com.wangtao.mylibrary.algorithm.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.ListNode;

/**
 * @author wangtao
 * @Description: leetCode(25):链表每K个节点反转，不满K个节点不反转：K = 3；1->2->3->4->5->6->7->8，反转成，3->2->1->6->5->4->7->8
 * @date 2019/8/16 16:47
 */
public class ReverseKNode {

    public static void main(String[] args) {
        ReverseKNode r = new ReverseKNode();

        ListNode list = ListNode.createLinkedList(8);
        ListNode result = r.reverseKNode(list, 5);
        ListNode.printList(result);

        /**
         * 拓展：从尾部开始每K个节点反转
         * 思路：先整个链表反转，然后再k个节点反转，再整个链表反转回去
         */
        ListNode list2 = ListNode.createLinkedList(8);
        list2 = r.reverse(list2);
        ListNode.printList(list2);
        list2 = r.reverseKNode(list2, 3);
        ListNode.printList(list2);
        list2 = r.reverse(list2);
        ListNode.printList(list2);
    }

    public ListNode reverseKNode(ListNode head, int k) {
        if (head == null) return null;
        ListNode result = head;

        ListNode tmpHead = head;
        ListNode tmpTail = head;
        ListNode cur = head;

        boolean firstReverse = true;
        while (cur != null) {
            int i = 0;
            //移动cur
            while (i < k - 1 && cur.next != null) {
                cur = cur.next;
                i++;
            }
            //够k个节点
            if (i == k - 1) {
                //保存cur.next节点
                ListNode next = cur.next;
                //cur.next置空，将next节点断开
                cur.next = null;
                ListNode h = reverse(tmpHead);
                if (firstReverse) {
                    //第一次反转的时候，记录要返回的头节点
                    result = h;
                    firstReverse = false;
                } else {
                    //将反转后的头结点插入临时的尾节点
                    tmpTail.next = h;
                }
                //尾节点移动下一个位置
                tmpTail = tmpHead;
                //将next节点连接起来
                tmpTail.next = next;
                //cur\tmpHead节点移动下一个节点，开始下一轮反转
                cur = next;
                tmpHead = next;
            } else {
                break;
            }
        }

        return result;
    }

    //链表反转
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            ListNode nn = next.next;
            next.next = cur;
            cur = next;
            next = nn;
        }
        head.next = null;

        return cur;
    }
}
