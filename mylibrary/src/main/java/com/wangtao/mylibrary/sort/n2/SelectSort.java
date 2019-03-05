package com.wangtao.mylibrary.sort.n2;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description:选择排序：n2,原地算法，不稳定排序
 * @date 2019/3/5 10:25
 */
public class SelectSort {

    /**
     * 最好：O(n2)
     * 最坏：O(n2)
     * 平均：O(n2)
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            Utils.swap(arr, i, minIndex);
        }
    }
}
