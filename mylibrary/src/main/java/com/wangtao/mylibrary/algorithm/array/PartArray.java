package com.wangtao.mylibrary.algorithm.array;

import com.wangtao.mylibrary.Utils;

/**
 * offer(14):输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 * 拓展：
 * ①将数组依照某种规则(奇偶、正负)划分成前后两部分 （规则抽取成函数）
 * ②不改变数值的相对位置
 */
public class PartArray {

    public static void main(String[] args) {
        PartArray parter = new PartArray();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        parter.part(arr);
        Utils.printArr(arr);
        parter.part2(arr1);
        Utils.printArr(arr1);
        parter.reOrderArray(arr3);
        Utils.printArr(arr3);
    }

    /**
     * 从两头向中间
     *
     * @param array
     */
    public void part(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        //i指向0，j指向末尾
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (i < j && isOddNumber(array[i])) {//奇数就移动下标 ，找到偶数
                i++;
            }

            while (i < j && !isOddNumber(array[j])) {//偶数就移动下标，找到奇数
                j--;
            }

            if (i != j) {
                Utils.swap(array, i, j);//奇数偶数交换
            }
        }
    }

    /**
     * 两个下标，一个方向遍历（太多这种用法了！！！）
     *
     * @param array
     */
    public void part2(int[] array) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (isOddNumber(array[j])) {
                Utils.swap(array, i++, j);
            }
        }
    }


    /**
     * 将判断规则抽取成方法
     *
     * @param n
     * @return
     */
    private boolean isOddNumber(int n) {
        return (n & 1) == 1;
    }

    private boolean isPositive(int n) {
        return n > 0;
    }

    /**
     * 不改变奇数偶数的相对位置
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (((array[j] & 1) == 1)) {
                if (i != j) {
                    int tmp = array[j];
                    while (i < j) {
                        array[j] = array[--j];
                    }
                    array[i] = tmp;
                }
                i++;
            }
        }
    }
}
