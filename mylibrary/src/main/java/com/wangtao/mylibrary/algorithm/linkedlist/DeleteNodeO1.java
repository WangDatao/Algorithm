package com.wangtao.mylibrary.algorithm.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;

/**
 * @author wangtao
 * @Description: offer(13):给定链表的头结点和要删除的节点，在O(1)时间删除链表节点
 * @date 2019/5/13 11:38
 */

/**
 * 考察：
 * ①链表的基本操作
 * ②特殊情况处理
 */
public class DeleteNodeO1 {

    public static void main(String[] args) {
        DeleteNodeO1 deleter = new DeleteNodeO1();
        deleter.test1();
        deleter.test2();
        deleter.test3();
        deleter.test4();
    }

    /**
     * 只有一个节点
     */
    private void test1() {
        Wrapper wrapper = createLinkedList(1, 0);
        Node<Integer> result = remove(wrapper.head, wrapper.target);
        printLinkedList(result);
    }

    /**
     * 多个节点，删除中间节点
     */
    private void test2() {
        Wrapper wrapper = createLinkedList(10, 3);
        Node<Integer> result = remove(wrapper.head, wrapper.target);
        printLinkedList(result);
    }

    /**
     * 删除尾节点
     */
    private void test3() {
        Wrapper wrapper = createLinkedList(10, 9);
        Node<Integer> result = remove(wrapper.head, wrapper.target);
        printLinkedList(result);
    }

    /**
     * 删除头结点
     */
    private void test4() {
        Wrapper wrapper = createLinkedList(10, 0);
        Node<Integer> result = remove(wrapper.head, wrapper.target);
        printLinkedList(result);
    }


    /**
     * @param head       头结点
     * @param targetNode 目标节点（在链表上）
     */
    public Node<Integer> remove(Node<Integer> head, Node<Integer> targetNode) {
        if (head == null || targetNode == null) return null;

        if (head == targetNode) {//删除的是头结点(隐藏了只有一个节点的情况)
            return head.next;
        }
        //多于1一个节点
        if (targetNode.next == null) {//要删除的节点是尾节点：需要遍历查找到，时间复杂度O(n)，但是平均时间复杂度还是O(1)
            Node<Integer> next = head;
            while (next.next != targetNode) {
                next = next.next;
            }
            next.next = null;
        } else {//删除的是中间节点：将目标节点的下一个节点的值赋值给目标节点；再将下一个节点删除（目标节点没有被删除）
            Node<Integer> next = targetNode.next;
            targetNode.value = next.value;
            targetNode.next = next.next;
            next = null;
        }

        return head;
    }

    private Wrapper createLinkedList(int n , int target) {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Node<Integer> targetNode = null;
        for (int i = 0; i < n; i++) {
            Node<Integer> newNode = new Node<>(i);
            if(i == target) targetNode = newNode;
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        return new Wrapper(head , targetNode);
    }

    private void printLinkedList(Node<Integer> head) {
        while (head != null) {
            System.out.printf("->"+head.value);
            head = head.next;
        }
        System.out.println();
    }

    private static class Wrapper {
        public Node<Integer> head;
        public Node<Integer> target;

        public Wrapper(Node<Integer> head, Node<Integer> target) {
            this.head = head;
            this.target = target;
        }
    }
}
