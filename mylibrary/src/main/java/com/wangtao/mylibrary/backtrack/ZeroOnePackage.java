package com.wangtao.mylibrary.backtrack;

/**
 * @author wangtao
 * @Description:0-1背包问题 背包问题有很多变体，我这里介绍一种比较基础的。
 * 我们有一个背包，背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 * @date 2019/1/16 14:58
 */
public class ZeroOnePackage {
    /**
     * 存储背包中物品总重量的最大值
     */
    public int maxW = Integer.MIN_VALUE;
    /**
     * 物品重量数组
     */
    private int[] items;
    /**
     * 物品个数 items.length
     */
    private int n;
    /**
     * 背包可承受的重量
     */
    private int w;
    /**
     * 优化，记录已经出现过的情况
     */
    public boolean[][] memory;

    public ZeroOnePackage(int w, int[] items) {
        this.n = items.length;
        this.w = w;
        this.items = items;
        memory = new boolean[n][w];
    }


    /**
     * @param i  考察到的物品下标
     * @param cw 背包中已有的重量
     */
    public void f(int i, int cw) {
        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            if (cw > maxW) maxW = cw;
            return;
        }
        //表示不把第i个物品放入背包
        f(i + 1, cw);
        //表示把第i个物品放入背包
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            f(i + 1, cw + items[i]);
        }
    }

    /**
     * 利用memory 优化
     * @param i
     * @param cw
     */
    public void ff(int i, int cw) {
        if (cw == w || i == n) {
            maxW = cw > maxW ? cw : maxW;
            return;
        }
        if (memory[i][cw])
            return;
        memory[i][cw] = true;
        f(i + 1, cw);
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i]);
        }
    }

}
