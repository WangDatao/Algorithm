package com.wangtao.mylibrary.classic.sort.nlogn;

import com.wangtao.mylibrary.Utils;

/**
 * @author wangtao
 * @Description: 无序数组，在O(n)的时间复杂度内查找第K大的数字？ 快速排序，每次可以得到一个pivot值，
 * 如果pivot+1 = k,那么arr[pivot] 就是第K大;
 * 如果 pivot+1 < k ,那么在arr[pivot]之后的区间内查找
 * 如果pivot+1 > k,那么在arr[pivot]之前的区间查找
 * @date 2019/3/7 17:44
 */
public class FindKthValue {
    public static int searchKth(int[] arr, int k) {
        if (null == arr || k > arr.length || k < 1) return -999;
        return partKth(arr, 0, arr.length - 1, k);
    }

    public static int partKth(int[] arr, int p, int r, int k) {
        int pivot = part(arr, p, r);
        if (pivot + 1 == k) {
            return arr[pivot];
        } else if (pivot + 1 < k) {
            return partKth(arr, pivot + 1, r, k);
        } else {
            return partKth(arr, p, pivot - 1, k);
        }
    }

    public static int part(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
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


}
