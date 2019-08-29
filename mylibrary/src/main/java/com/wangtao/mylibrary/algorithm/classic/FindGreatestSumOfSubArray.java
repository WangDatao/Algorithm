package com.wangtao.mylibrary.algorithm.classic;

/**
 * @author wangtao
 * @Description: offer(31):连续子数组的最大和-例如输入的数组为{1, -2, 3, 10, -4, 7, 2, -5}，和最大的子数组为｛3, 10, -4, 7, 2}。因此输出为该子数组的和18 。
 * @date 2019/8/29 14:38
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        FindGreatestSumOfSubArray finder = new FindGreatestSumOfSubArray();
        int[] arr = {-1, -2, -3, -4, -5, -6};
        int[] arr2 = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] arr3 = {2, 8, 1, 5, 9};
        int[] arr4 = {-2, -3, -1, -4, -5, -6};
        System.out.println(finder.find(arr));
        System.out.println(finder.find(arr2));
        System.out.println(finder.find(arr3));
        System.out.println(finder.find(arr4));
    }

    public int find(int[] array) {
        if (array == null || array.length == 0) return 0;
        //记录最大值
        int max = array[0];
        //连续子数组的和
        int sum = 0;
        for (int i : array) {
            //连续子数组的和小于等于0
            if (sum <= 0) {
                //i加上小于等于0的数，肯定小于等于i
                sum = i;
            } else {
                sum += i;
            }
            //记录最大数值
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
