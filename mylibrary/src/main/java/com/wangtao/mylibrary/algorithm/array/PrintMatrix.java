package com.wangtao.mylibrary.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @Description: offer(20):
 * @date 2019/8/12 15:08
 */

/**
 * 每次输出一圈: 不一定每圈都有四个操作，控制范围
 * ①从左到右
 * ②从上到下
 * ③从右到左
 * ④从下到上
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        PrintMatrix printer = new PrintMatrix();
        ArrayList<Integer> list = printer.printMatrix(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) return null;
        ArrayList<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        int x = 0;
        int y = 0;

        while (x * 2 < matrix.length && y * 2 < matrix[0].length) {//还有没遍历到的
            printMatrixCircle(matrix, x, y, list);
            x++;
            y++;
        }
        return list;
    }

    /**
     * 每次一圈
     *
     * @param matrix
     * @param x
     * @param y
     * @param list
     */
    public void printMatrixCircle(int[][] matrix, int x, int y, List<Integer> list) {
        //起始行
        int rows = matrix.length;
        //起始列
        int cols = matrix[0].length;

        // 从左到右：输出环的上面一行
        for (int i = y; i <= cols - y - 1; i++) {
            list.add(matrix[x][i]);
        }

        //从上到下：输出环的右边一列
        if (rows - x - 1 > x) {//环的高度至少是2（前面已经输出过一行）
            //第一个数值已经被输出过，i= x+1；
            for (int i = x + 1; i <= rows - x - 1; i++) {
                list.add(matrix[i][cols - y - 1]);
            }
        }

        //从右到左：输出环的下面一行
        if (rows - x - 1 > x && cols - y - 1 > y) {//高度和宽度都必须是2以上（已经输出过一行一列）
            for (int i = cols - y - 2; i >= y; i--) {
                list.add(matrix[rows - x - 1][i]);
            }
        }

        //从下到上：输出环的左边一列
        if (cols - y - 1 > y && rows - x - 1 > x + 1) {//宽度至少是2，高度至少是3（输出过两行一列）
            for (int i = rows - x - 2; i >= x + 1; i--) {
                list.add(matrix[i][y]);
            }
        }
    }
}
