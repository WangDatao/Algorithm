package com.wangtao.mylibrary.algorithm.stack;

/**
 * @author wangtao
 * @Description: offer(22)：弹栈顺序
 * @date 2019/8/15 11:03
 */

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

import java.util.Stack;

/**
 * 思路：
 * 1.如果是一次性全部压栈再全部弹出，那就很简单了。
 * 2.压栈之后可以立即弹出，可以用一个辅助栈
 */
public class StackPopOrder {

    public static void main(String[] args) {
        StackPopOrder popOrder = new StackPopOrder();
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};
        int[] pop3 = {1, 2, 4, 3, 5};
        int[] pop4 = {3, 5, 4, 1, 2};
        int[] pop5 = {3, 5, 4, 2, 1};

        System.out.println("true : " + popOrder.IsPopOrder(push, pop));
        System.out.println("false : " + popOrder.IsPopOrder(push, pop2));
        System.out.println("true : " + popOrder.IsPopOrder(push, pop3));
        System.out.println("false : " + popOrder.IsPopOrder(push, pop4));
        System.out.println("true : " + popOrder.IsPopOrder(push, pop5));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || pushA.length == 0 || popA == null || pushA.length != popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        //顺序数组已入栈的下标
        int pushIndex = 0;

        for (int i = 0; i < popA.length; i++) {
            int top = popA[i];
            //比较栈顶数据，是否匹配
            if (!stack.isEmpty() && stack.peek() == top) {
                stack.pop();//弹出栈顶数据
            } else {
                //标记是否从顺序数组剩余的数值中找到
                boolean find = false;
                //栈顶数据不匹配，就需要按顺序入栈
                for (; pushIndex < pushA.length; pushIndex++) {
                    //不匹配，压入栈
                    if (pushA[pushIndex] != top) {
                        stack.push(pushA[pushIndex]);
                    } else {
                        //找到，标记设置为true,不需要压入栈
                        find = true;
                        pushIndex++;//要跳出内循环，pushIndex手动+1
                        break;

                    }
                }

                if (!find) {
                    return false;
                }
            }

        }
        return true;
    }
}
