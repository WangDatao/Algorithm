package com.wangtao.mylibrary.algorithm.linkedlist;

/**
 * @author wangtao
 * @Description: offer(26)：复制复杂的链表-复杂链表中，每个结点除了有一个next 域指向下一个结点外，
 * 还有一个random 指向链表中的任意结点或者null
 * @date 2019/8/21 9:35
 */

public class CloneComplexList {

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        RandomListNode head = null;
        RandomListNode tail = null;
        for (int i = 0; i < 5; i++) {
            if (head == null) {
                head = tail = new RandomListNode(i + 1);
            } else {
                tail.next = new RandomListNode(i + 1);
                tail = tail.next;
            }
        }
        CloneComplexList cloner = new CloneComplexList();
        RandomListNode result = cloner.cloneList(head);
        System.out.println("print head：");
        printList(head);
        System.out.println();
        System.out.println("print result：");
        printList(result);
    }

    public RandomListNode cloneList(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;

        //①插入新的节点：A->B->C  => A->a->B-b->C->c
        while (cur != null) {
            RandomListNode n = cur.next;
            RandomListNode newNode = new RandomListNode(cur.label);
            cur.next = newNode;
            newNode.next = n;
            cur = n;
        }
        //②复制random指针
        cur = pHead;
        while (cur != null) {
            if (cur.random != null) {//如果random指针不为空，
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //③拆分链表
        cur = pHead;
        RandomListNode result = null;
        RandomListNode tail = null;
        while (cur != null) {
            //获取复制链表的节点
            RandomListNode node = cur.next;
            //当前节点指向下一个位置
            cur.next = node.next;
            cur = node.next;
//            node.next = null;
            if (result == null) {
                result = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        return result;
    }

    private static void printList(RandomListNode result) {
        while (result != null) {
            System.out.print(result.label + "->");
            result = result.next;
        }
        System.out.print("null");
    }
}



