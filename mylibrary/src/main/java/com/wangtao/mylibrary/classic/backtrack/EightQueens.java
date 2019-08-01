package com.wangtao.mylibrary.classic.backtrack;

/**
 * @author wangtao
 * @Description:八皇后
 * @date 2019/1/16 10:09
 */
public class EightQueens {
    /**
     * 下标表示行，值表示queen存储的列
     */
    public static final int E = 8;
    private static final int[] result = new int[E];
    private static int resultCount;

    public static void cal8Queen() {
        resultCount = 0;
        cal8Queen(0);
        System.out.println("总共: " + resultCount + "种解法");
    }

    private static void cal8Queen(int row) {
        if (row == E) {
            resultCount++;
            printResult();
            return;
        }

        for (int column = 0; column < E; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queen(row + 1);
            }
        }
    }

    /**
     * 判断row 行 column 列是否满足
     *
     * @param row
     * @param column
     * @return
     */
    private static boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            //同一列
            if (result[i] == column) {
                return false;
            }
            //左上方
            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }
            //右上方
            if (rightUp < 8) {
                if (result[i] == rightUp) {
                    return false;
                }
            }

            --leftUp;
            ++rightUp;
        }
        return true;
    }

    /**
     * 打印二维矩阵
     */
    private static void printResult() {
        for (int row = 0; row < E; row++) {
            for (int column = 0; column < E; column++) {
                if (result[row] == column) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
