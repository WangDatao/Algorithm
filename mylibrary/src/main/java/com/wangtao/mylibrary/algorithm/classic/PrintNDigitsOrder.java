package com.wangtao.mylibrary.algorithm.classic;
/**
 * @author wangtao
 * @Description: offer(12):输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
 * @date 2019/8/10 17:05
 */

/**
 * ①大数问题,不能直接求n位最大数，再遍历
 * ②模拟数值进位操作
 */
public class PrintNDigitsOrder {

    public static void main(String[] args) {
        PrintNDigitsOrder printer = new PrintNDigitsOrder();
        printer.print(3);
    }


    public void print(int n) {
        if (n <= 0) return;
        //创建一个表示n位数的数组，每一位的值范围：0~9
        int[] arr = new int[n];
        int index = 0;
        while ((index = add(arr, index)) < n) {
            printArr(arr, index);
        }
    }

    /**
     * @param arr       数组
     * @param lastIndex 上次的下标值
     * @return
     */
    private int add(int[] arr, int lastIndex) {
        int index = 0;//+1操作的下标，都是从0下标开始（一个数+1，不就是从个位数开始+？）
        boolean up;//是否发生进位
        do {
            int v = ++arr[index];
            if (v > 9) {//发生进位
                arr[index] = 0;//当前下标数值设置为0
                index++;//下标后移
                if (index == arr.length) return index;//超过最大，直接返回
                up = true;
            } else {//没有发生进位
                up = false;
            }
        } while (up);

        return lastIndex > index ? lastIndex : index;
    }

    private void printArr(int[] arr, int index) {
        for (int i = index; i >= 0; i--) {
            System.out.printf(arr[i] + "");
        }
        System.out.println();
    }

}
