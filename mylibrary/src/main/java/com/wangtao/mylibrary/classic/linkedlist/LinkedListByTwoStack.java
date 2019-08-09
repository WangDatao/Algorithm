package com.wangtao.mylibrary.classic.linkedlist;

import java.util.Stack;

/**
 * @author wangtao
 * @Description: offer(7):用两个栈实现一个链表
 * @date 2019/8/9 14:39
 */
public class LinkedListByTwoStack {

    /**
     * 1.stack1用于入队：a、b、c压栈,a->b->c，c在栈顶
     *
     * 2.出队时：
     *  如果stack2为空，需要将stack1的数据一一弹出并压入stack2:c->b->a，a在栈顶；stack2再弹栈
     *  如果stack2不为空，直接stack2弹栈
     *
     * 3.入队就往stack1中压栈，出队就从stack2弹栈；stack2为空，stack1数据先弹出到stack2中
     *
     * 4.联想：如何用两个栈实现浏览器的前进和后退？
     * 打开新网页，往栈1中压栈；后退，从栈1中弹栈，压入栈2；前进，从栈2弹栈，压入
     */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();



    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
