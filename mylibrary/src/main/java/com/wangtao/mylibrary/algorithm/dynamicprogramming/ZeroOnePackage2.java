package com.wangtao.mylibrary.algorithm.dynamicprogramming;

/**
 * @author wangtao
 * @Description:动态规划，0/1背包问题，升级
 * @date 2019/1/17 16:53
 */
public class ZeroOnePackage2 {

    public static int knapsack(int[] weights, int[] values, int n, int w) {
        int[][] states = new int[n][w + 1];
        //初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                states[i][j] = -1;
            }
        }
        //第一个物品特殊处理
        states[0][0] = 0;
        states[0][weights[0]] = values[0];
        //动态规划
        for (int i = 1; i < n; i++) {
            //第i个物品不加入背包
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            //第i个物品加入背包
            for (int j = 0; j <= w - weights[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    int value = states[i - 1][j] + values[i];
                    if (value > states[i][j + weights[i]]) {//物品序号和当前载重相同时，只保留价值最大的
                        states[i][j + weights[i]] = value;
                    }
                }
            }
        }

        int maxValue = -1;
        for (int i = 0; i <= w; i++) {
            if (states[n - 1][i] > maxValue) maxValue = states[n - 1][i];
        }

        return maxValue;
    }
}
