package com.wangtao.mylibrary.dynamicprogramming;

/**
 * @author wangtao
 * @Description:简单0/1背包问题，动态规划算法（一）
 * @date 2019/1/16 16:25
 */
public class ZeroOnePackage {

    /**
     * @param weight 物品重量数组
     * @param n      物品数量
     * @param w      背包最大载重
     * @return
     */
    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        //第一个物品特殊处理
        states[0][0] = true;//不加入背包
        states[0][weight[0]] = true;//加入背包
        for (int i = 1; i < n; i++) {
            //第i个物品不加入背包
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j] == true) states[i][j] = true;
            }
            //第i个物品加入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j]) states[i][j + weight[i]] = true;
            }
        }

        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) return i;
        }
        return 0;
    }
}
