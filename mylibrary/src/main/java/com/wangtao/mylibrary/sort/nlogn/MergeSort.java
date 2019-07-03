package com.wangtao.mylibrary.sort.nlogn;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description:归并排序：O(nlogn);稳定排序；非原地
 * @date 2019/3/5 11:39
 */
public class MergeSort {
    /**
     * 时间复杂度，最好、最坏都是O(nlogn)
     * 空间复杂度：O(n)
     */

    public static void main(String[] args) {
        int[] arr = {2, 1, 20, 13, 33, -1, 0};
        MergeSort.sort(arr);
        Utils.printArr(arr);
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int p, int q) {
        if (p >= q) {
            return;
        }
        int m = (p + q) / 2;
        mergeSort(arr, p, m);
        mergeSort(arr, m + 1, q);
        merge(arr, p, m, q);
    }

    public static void merge(int[] arr, int p, int m, int q) {
        int i = p, k = p, j = m + 1;
        //临时数组（归并排序，不适合大规模数据的排序就是因为需要额外的空间）
        int tmpArr[] = new int[arr.length];

        while (i <= m && j <= q) {
            if (arr[i] <= arr[j]) {
                tmpArr[k] = arr[i];
                i++;
            } else {
                tmpArr[k] = arr[j];
                j++;
            }
            k++;
        }
        //剩余的
        int leftStart;
        int leftEnd;
        if (i <= m) {
            leftStart = i;
            leftEnd = m;
        } else {
            leftStart = j;
            leftEnd = q;
        }

        while (leftStart <= leftEnd) {
            tmpArr[k] = arr[leftStart];
            k++;
            leftStart++;
        }
        //从临时数组中拷贝
        for (int l = p; l <= q; l++) {
            arr[l] = tmpArr[l];
        }
    }
}
