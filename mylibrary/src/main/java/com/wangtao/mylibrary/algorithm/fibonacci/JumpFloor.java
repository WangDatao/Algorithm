package com.wangtao.mylibrary.algorithm.fibonacci;

import java.util.HashMap;

/**
 * @author wangtao
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @date 2019/8/9 17:11
 */
public class JumpFloor {

    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.jumpFloor(5));
        System.out.println(jumpFloor.JumpFloor(5));
    }

    private HashMap<Integer, Integer> cache = new HashMap();

    /**
     * 第n阶前面有两种跳法：跳1阶或者2阶
     *
     * @param target
     * @return
     */
    public int jumpFloor(int target) {

        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        int i = jumpFloor(target - 1);
        if (!cache.containsKey(target - 1)) cache.put(target - 1, i);
        int i1 = jumpFloor(target - 2);
        if (!cache.containsKey(target - 2)) cache.put(target - 2, i1);

        return i + i1;
    }

    public int JumpFloor(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;

        int pp = 1;
        int p = 2;
        int current = 3;

        for (int i = 3; i <= target; i++) {
            current = pp + p;
            pp = p;
            p = current;
        }
        return current;
    }
}
