package com.wangtao.mylibrary;

/**
 * @author wangtao
 * @Description:工具类
 * @date 2019/2/12 14:38
 */
public class Utils {

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
