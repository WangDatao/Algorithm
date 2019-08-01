package com.wangtao.mylibrary.classic.array;

/**
 * @author wangtao
 * @Description: 给定两个排序的大数组和小数组 ，大数组是否包含小数组的所有元素
 * @date 2019/8/1 18:09
 */
public class ContainSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] subArr = {1, 2, 4};
        int[] subArr2 = {1, 2, 9};

        System.out.println(contain(arr, subArr));
        System.out.println(contain(arr, subArr2));
    }

    public static boolean contain(int[] arr, int[] subArr) {
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == subArr[i]) {
                if (++i == subArr.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
