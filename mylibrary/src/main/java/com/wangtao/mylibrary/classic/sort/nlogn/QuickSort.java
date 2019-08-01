package com.wangtao.mylibrary.classic.sort.nlogn;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description: 快速排序:O(nlogn); 原地排序； 非稳定
 * @date 2019/3/7 9:22
 */
public class QuickSort {


    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int p, int r) {
        if (p >= r) return;
        int i = part2(arr, p, r);

        quickSort(arr, p, i - 1);
        quickSort(arr, i + 1, r);
    }

    /**
     * 这种写法，i 指向大于等于pivot的数
     *
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public static int part(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;

        for (int j = p; j <= r; j++) {
            if (arr[j] < pivot) {
                if (i != j) {
                    Utils.swap(arr, i, j);
                }
                i++;
            }
        }

        Utils.swap(arr, i, r);
        return i;
    }

    /**
     * 以最后一个数字为基准，则必须左边的先开始移动!!!
     * 以第一个数字为基准，则必须右侧先开始移动!!!
     *
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public static int part2(int[] arr, int p, int r) {
        int pivot = arr[r];
        int left = p;
        int right = r;

        while (left < right) {
            while (arr[left] <= pivot && left < right) {
                left++;
            }

            while (arr[right] >= pivot && left < right) {
                right--;
            }

            if (left < right) {
                Utils.swap(arr, left, right);
            }
        }

        Utils.swap(arr, left, r);
        return left;
    }
}
