package com.wangtao.mylibrary.algorithm.stack;

import java.util.Stack;

/**
 * @author wangtao
 * @Description: offer(21):  定义栈的数据结构，请在该类型中实现一个能够得到栈的最小素的min 函数。在该栈中，调用min、push 及pop的时间复杂度都是0(1)
 * @date 2019/8/15 10:05
 */


public class MinNumStack {

    public static void main(String[] args) {
        MinNumStack minNumStack = new MinNumStack();

        minNumStack.push(5);
        System.out.println("min num == " + minNumStack.min());
        minNumStack.push(4);
        System.out.println("min num == " + minNumStack.min());
        minNumStack.push(6);
        System.out.println("min num == " + minNumStack.min());
        minNumStack.push(3);
        System.out.println("min num == " + minNumStack.min());
        minNumStack.top();
        System.out.println("top num == " + minNumStack.top());
        minNumStack.pop();
        System.out.println("min num == " + minNumStack.min());

    }

    /**
     * 数据栈：保存数据
     */
    private Stack<Integer> mStack = new Stack<>();
    /**
     * 辅助栈：用于记录数据栈中最小数的下标
     */
    private Stack<Integer> mAssistStack = new Stack<>();

    public void push(int node) {
        if (mStack.isEmpty()) {
            mStack.push(node);
            mAssistStack.push(0);
        } else {
            //未压入数据时，获取栈中最小值
            Integer peek = mAssistStack.peek();
            mStack.push(node);
            //比较最小值
            if (node < mStack.get(peek)) {
                //新压入的数值更小，辅助栈记录下标——最后一位
                mAssistStack.push(mStack.size() - 1);
            } else {
                mAssistStack.push(peek);//这里需要理解一点，min函数只是获取栈中最小值，而不是获取最小值时，同时从栈中弹出
            }
        }
    }

    public void pop() {
        if (!mStack.isEmpty()) {
            mStack.pop();
            mAssistStack.pop();
        }
    }

    public int top() {
        if (mStack.isEmpty()) throw new IllegalStateException("empty stack");
        return mStack.peek();
    }

    public int min() {
        if (mStack.isEmpty()) throw new IllegalStateException("empty stack");
        return mStack.get(mAssistStack.peek());
    }
}
