package com.wangtao.mylibrary.datastructure.bitmap;

/**
 * @author wangtao
 * @Description:位图，每一个二进制数的位表示一个数： http://www.cnblogs.com/huangxincheng/archive/2012/12/06/2804756.html
 * @date 2019/2/14 11:13
 */
public class Bitmap {
    /**
     * 实例：我们有 1 千万个整数，整数的范围在 1 到 1 亿之间。如何快速查找某个整数是否在这 1 千万个整数中呢？
     */
    /**
     * char类型，2个字节，16位；
     * bytes[0]:表示0~15
     * bytes[1]:表示16~31
     * ....
     */
    private char[] bytes;
    //最大数值
    private int nBits;

    public Bitmap(int nBits) {
        this.nBits = nBits;
        this.bytes = new char[nBits / 16 + 1];
    }

    public void set(int k) {
        if (k > nBits) return;
        //数组下标：k>>4同k/16
        int byteIndex = k >> 4;
        //位下标： k&0xf同 k%16
        int bitIndex = k & 0xf;
        //如传入7：byteIndex=0 ， bitIndex = 7
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nBits) return false;
        //数组下标：k>>4同k/16
        int byteIndex = k >> 4;
        //位下标： k&0xf同 k%16
        int bitIndex = k & 0xf;

        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}
