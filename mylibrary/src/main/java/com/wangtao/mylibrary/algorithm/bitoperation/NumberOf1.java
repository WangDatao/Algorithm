package com.wangtao.mylibrary.algorithm.bitoperation;

/**
 * @author wangtao
 * @Description: offer(10)：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 * @date 2019/8/9 17:36
 */
public class NumberOf1 {

    public static void main(String[] args) {
        NumberOf1 number = new NumberOf1();
        System.out.println(number.count(0));
        System.out.println(number.count(1));
        System.out.println(number.count(3));
        System.out.println(number.count(-1));//负数，补码-符号位不变，取反，加一
    }

    /**
     * 通过位移跟1与运算
     *
     * @param n
     * @return
     */
    public int count(int n) {
        int count = 0;
        //int型，最大32位（符号为也算）
        for (int i = 0; i <= 32; i++) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }

    public int count2(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
