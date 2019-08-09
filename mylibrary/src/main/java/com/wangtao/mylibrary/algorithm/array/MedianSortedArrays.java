package com.wangtao.mylibrary.algorithm.array;

/**
 * @author wangtao
 * @Description: leetcode<4>: 两个排序数组的中位数
 * @date 2019/8/5 16:03
 */
public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] sA = {1, 2, 3, 4};
        int[] lA = {5, 6, 7, 8};
        System.out.println(findMedianSortedArrays(sA, lA));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //区分长短数组,用短数组进行二分查找，避免越界;减少搜索次数
        int[] sArr = nums1.length < nums2.length ? nums1 : nums2;
        int[] lArr = nums1.length >= nums2.length ? nums1 : nums2;

        int s = sArr.length;
        int l = lArr.length;

        int start = 0;
        int end = s;//end 不需要 -1,
        int mid = (s + l + 1) >> 1;

        while (start <= end) {
            int i = (start + end) >> 1;
            int j = mid - i;

            if (i < end && sArr[i] < lArr[j - 1]) {
                //i值偏小，i右移动
                start = i + 1;
            } else if (i > start && sArr[i - 1] > lArr[j]) {
                //i值偏大,i左移动
                end = i - 1;
            } else {
                int maxLeft;//左半部分最大值

                //找到合适的i:
                /**
                 * 1.sArr全部大于lArr
                 * 2.sArr全部小于lArr；
                 * 3.sArr部分大于lArr，部分小于lArr
                 */
                if (i == 0) {
                    //1
                    maxLeft = lArr[j - 1];
                } else if (j == 0) { //i == n不能推出，结论2；j == 0能推结论2
                    //2
                    maxLeft = sArr[i - 1];
                } else {
                    //3
                    maxLeft = Math.max(sArr[i - 1], lArr[j - 1]);
                }
                //总数组个数为奇数
                System.out.println("maxLeft " + maxLeft);
                if ((s + l) % 2 == 1) {
                    return maxLeft;
                }

                //右半部分，最小值
                int minRight;
                if (i == s) {
                    minRight = lArr[j];
                } else if (j == l) {
                    minRight = sArr[i];
                } else {
                    minRight = Math.min(sArr[i], lArr[j]);
                }
                System.out.println("minRight " + minRight);
                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }
}
