package com.wangtao.mylibrary.classic.array;

/**
 * @author wangtao
 * @Description: leetcode<26>:给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @date 2019/8/1 17:54
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(removeDuplicates(arr));
    }

    //ArrayList removeAll()/retainAll()的算法
    public static int removeDuplicates(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[j] != arr[i]) {
                arr[++j] = arr[i];
            }
        }

        return j + 1;
    }
}
