package com.wangtao.mylibrary.classic;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangtao
 * @Description: 单链表是否有环
 * @date 2019/5/13 11:38
 */
public class CycleLinkedList<Data> {

    /**
     * 快慢指针法
     *
     * @param head
     * @return
     */
    public boolean hasCycleByTwoPoint(Node<Data> head) {
        if (null == head) return false;
        Node<Data> slow = head;
        Node<Data> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    /**
     * 通过存储所有访问过的节点
     *
     * @param head
     * @return
     */
    public boolean hasCycleByHashSet(Node<Data> head) {
        if (head == null) return false;
        Set<Node<Data>> nodeSet = new HashSet<>();
        while (null != head) {
            if (nodeSet.contains(head)) return true;
            nodeSet.add(head);
            head = head.next;
        }

        return false;
    }
}
