package com.wangtao.mylibrary.algorithm.sort.n2;

/**
 * @author wangtao
 * @Description:插入排序：n²;原地排序;稳定排序
 * @date 2019/2/27 17:35
 */
public class InsertSort {
    /**
     * 最好：已经有序,O（n）
     * 最坏：倒序，O(n2)
     * 平均：O(n2)
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > value) {
                    //只需要一个赋值语句 ：而冒泡排序需要三条赋值语句
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = value;
                    break;
                }
            }
        }
    }
}
