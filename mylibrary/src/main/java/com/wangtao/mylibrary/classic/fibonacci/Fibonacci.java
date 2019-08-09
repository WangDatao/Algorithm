package com.wangtao.mylibrary.classic.fibonacci;

/**
 * @author wangtao
 * @Description: offer(9):斐波那契数列
 * @date 2019/8/9 16:38
 */

import java.util.HashMap;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {
    /**
     * 递归方式优化：计算过的数值存储起来，直接使用
     */
    private HashMap<Integer, Integer> cache = new HashMap();

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci(20));
        System.out.println(fibonacci.fibonacciByRecursive(20));
    }

    /**
     * 循环
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) return 1;

        int pp = 1;

        int p = 1;

        int current = 2;

        for (int i = 3; i <= n; i++) {
            current = pp + p;
            pp = p;
            p = current;
        }

        return current;
    }

    public int fibonacciByRecursive(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int pValue = fibonacciByRecursive(n - 1);
        if (!cache.containsKey(n - 1)) {
            cache.put(n - 1, pValue);
        }
        int ppValue = fibonacciByRecursive(n - 2);
        if (!cache.containsKey(n - 2)) {
            cache.put(n - 2, ppValue);
        }
        return pValue + ppValue;
    }

}
