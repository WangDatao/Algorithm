package com.wangtao.mylibrary.algorithm.classic;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description: offer(29):无序数组中，个数超过一半的数字
 * @date 2019/8/13 9:26
 */

public class MoreThanHalfNum {
    public static void main(String[] args) {
        MoreThanHalfNum num = new MoreThanHalfNum();

        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr2 = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        int[] arr3 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr4 = {1};
        int i = num.MoreThanHalfNum_Solution(arr);
        System.out.println(i);
        Utils.printArr(arr);
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("");
        }
        //找到数组中间的数值，但是还不能确定
        int result = partMethod(array, 0, array.length - 1);

        int count = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > array[result]) break;
            if (array[j] == array[result]) count++;
        }

        return count > array.length / 2 ? array[result] : 0;
    }

    /**
     * 方法1：利用超过一半的数值个数大于其他数字个数总和，这个特点
     *  遍历数组，如果发现数字和下一个数字相同，计数count++，否则count--
     *  类似玩一对一抵消
     * @param array
     * @return
     */
    private int countMethod(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("");
        }
        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
            } else if (result == array[i]) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int value : array) {
            if (value == result) count++;
        }
        return count > array.length / 2 ? result : 0;
    }


    /**
     * 数组中超过一半的数字，排序后，一定在中间位置，
     * 所以这题目就相当于找第K大的数字，k == array.length/2
     * 但是如果，没有明确说，数组中一定有超过一半的数值，就还需要遍历一边，统计个数
     *
     * @param array
     * @param s
     * @param e
     * @return
     */
    private int partMethod(int[] array, int s, int e) {
        int p = part(array, s, e);
        if (p == array.length / 2) {
            return p;
        } else if (p > array.length / 2) {
            return partMethod(array, s, p - 1);
        } else {
            return partMethod(array, p + 1, e);
        }
    }

    private int part(int[] array, int s, int e) {
        int point = array[e];
        int i = s;

        for (int j = s; j < e; j++) {
            if (array[j] < point) {
                if (i != j) {
                    Utils.swap(array, i, j);
                }
                i++;
            }
        }
        Utils.swap(array, i, e);
        return i;
    }


}
