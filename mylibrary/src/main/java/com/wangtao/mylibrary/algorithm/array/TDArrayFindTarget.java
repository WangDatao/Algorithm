package com.wangtao.mylibrary.algorithm.array;

/**
 * @author wangtao
 * @Description: offer<3>:二维数组(从左/上到右/下递增)中是否包含给定值
 * @date 2019/8/8 11:10
 */
public class TDArrayFindTarget {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        System.out.println("contain "+3+" :"+find(3 , arr));
        System.out.println("contain "+8+" :"+find(8 , arr));
        System.out.println("contain "+20+" :"+find(3 , arr));
    }


    /**
     * 关键思路：取二维数组左下角/右上角的点比较;
     *           这两个点在一个维度上是最大，另一个维度上是最小；
     *           通过与目标值比较，可以缩小一个维度。
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        if (array == null || array.length < 1 || array[0].length < 1) {
            return false;
        }
        //最大行列
        int maxRow = array.length;
        int maxCol = array[0].length;

        //起始行列,右上角
        int row = 0;
        int col = maxCol - 1;
        while (row < maxRow && col >= 0) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
