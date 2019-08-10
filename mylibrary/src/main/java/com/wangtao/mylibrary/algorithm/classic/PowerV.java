package com.wangtao.mylibrary.algorithm.classic;

/**
 * @author wangtao
 * @Description: offer(11):数值的整数次方
 * @date 2019/8/10 16:27
 */
public class PowerV {

    public static void main(String[] args) {
        PowerV po = new PowerV();
        System.out.println(po.power(1, 3));
        System.out.println(po.power(1, -2));
        System.out.println(po.power(2, 3));
        System.out.println(po.power(2, -3));
        System.out.println(po.power(2, 4));
        System.out.println(po.power(2, 10));
    }

    /**
     * 思路：
     * ①特殊情况，底数为0，指数为0；指数为负数
     * ②n = n/2 + n/2  ,大拆分成小
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {

        if (base == 0 && exponent == 0) {
            throw new IllegalArgumentException("invalidate input");
        }

        if (exponent == 0 || base == 1) {
            return 1;
        }
        int abs = exponent;
        if (exponent < 0) {//负数次方
            abs = -exponent;
        }

        double result = powerWithUnsignedExponent(base, abs);
        if (exponent < 0) {//负数次方，求倒数
            result = 1 / result;
        }

        return result;
    }

    public double powerWithUnsignedExponent(double base, int exponent) {
//        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;

       if((exponent & 1) ==1){//奇数次方
           result *= base;
       }

        return result;
    }
}
