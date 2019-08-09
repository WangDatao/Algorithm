package com.wangtao.mylibrary.algorithm.sort.n2;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description:冒泡排序： n²;原地排序;稳定排序
 * @date 2019/2/27 16:28
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        if (null == arr || arr.length <= 1)
            return;
        /**
         *
         * 最好：一次冒泡操作，O(n)
         * 最坏：所有数据相反,O(n²)
         *
         * 满有序度：n*(n-1)/2
         * 最好：有序度n*(n-1)/2 ，交换次数0
         * 最坏：有序度0 ，交换n*(n-1)/2
         * 平均（估值）:n*(n-1)/4 =>O(n²)
         */

        for (int i = 0; i < arr.length - 1; i++) {
            //优化:如果一次冒泡操作都没有交换，则说明已经排序完成
            boolean swapFlag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    Utils.swap(arr, j, j + 1);
                    swapFlag = true;
                }
            }
            if (!swapFlag)
                break;
        }
    }
}
