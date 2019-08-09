package com.wangtao.mylibrary.algorithm.backtrack;

/**
 * @author wangtao
 * @Description:0/1背包问题，升级 我们刚刚讲的背包问题，只涉及背包重量和物品重量。我们现在引入物品价值这一变量。
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，
 * 背包中可装入物品的总价值最大是多少呢？
 * @date 2019/1/17 16:12
 */
public class ZeroOnePackage2 {

    public int maxV = Integer.MIN_VALUE;

    /**
     * 重量数组
     */
    int[] weights;
    /**
     * 价值数组
     */
    int[] values;
    int n;
    /**
     * 背包最大承载量
     */
    int w;

    public ZeroOnePackage2(int[] weights, int[] values, int w) {
        this.weights = weights;
        this.values = values;
        this.w = w;
        this.n = weights.length;
    }

    /**
     * @param i
     * @param cw
     * @param cv
     */
    public void f(int i, int cw, int cv) {
        if (cw == w || i == n) {
            maxV = maxV > cv ? maxV : cv;
            return;
        }

        //第i个物品不加入背包
        f(i + 1, cw, cv);
        //第i个物品加入背包
        if (weights[i] <= w - cw) {
            f(i, cw + weights[i], cv + values[i]);
        }

    }
}
