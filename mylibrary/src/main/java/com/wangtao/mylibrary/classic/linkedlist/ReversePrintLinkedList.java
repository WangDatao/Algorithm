package com.wangtao.mylibrary.classic.linkedlist;

import com.wangtao.mylibrary.datastructure.linkedlist.Node;
import com.wangtao.mylibrary.datastructure.stack.LinkedListStack;

/**
 * @author wangtao
 * @Description: offer<4>:从尾到头打印单链表-1.递归打印（单链表反转）2.利用一个栈，LIFO
 * @date 2019/8/8 15:06
 */
public class ReversePrintLinkedList {

    public static void main(String[] args) {
        Node<Integer> head = null;
        Node<Integer> pre = null;
        for (int i = 0; i < 3; i++) {
            if (head == null) {
                head = new Node<>(i);
                pre = head;
            } else {
                pre.next = new Node<>(i);
                pre = pre.next;
            }
        }

        reversePrint(head);
    }

    /**
     * 反转打印
     * @param head
     */
    public static void reversePrint(Node<Integer> head) {
        if (head == null) {
            return;
        }
//        recursivePrint(head);
        stackPrint(head);
    }

    /**
     * 递归打印，和单链表反转的想法一致
     */
    private static void recursivePrint(Node<Integer> node) {
        if (node.next != null) {
            recursivePrint(node.next);
        }
        System.out.print(node.value + " ");
    }

    private static void stackPrint(Node<Integer> node) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        //先压栈
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }
        //再弹栈
        Integer value;
        while ((value = stack.pop()) != null) {
            System.out.print(value + " ");
        }

    }

}
