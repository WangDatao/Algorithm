package com.wangtao.mylibrary.algorithm.array;

import com.wangtao.mylibrary.Utils;

import java.util.HashMap;

/**
 * @author wangtao
 * @Description: leetcode<1>给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @date 2019/8/1 17:40
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 20};
        Utils.printArr(twoSum(arr, 22));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(v) && map.get(v) != i) {
                result[0] = map.get(v);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
