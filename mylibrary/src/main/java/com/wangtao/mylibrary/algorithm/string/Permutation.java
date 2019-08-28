package com.wangtao.mylibrary.algorithm.string;

import java.util.ArrayList;

/**
 * @author wangtao
 * @Description: offer(28)：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @date 2019/8/23 9:26
 */

/**
 * https://blog.csdn.net/NEOMc/article/details/7533049
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();

        ArrayList<String> result = permutation.permutation("abcd");

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public ArrayList<String> permutation(String str) {
        if (null == str || str.length() == 0) return new ArrayList<>(0);
        ArrayList<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        permutationInternal(chars, 0, result);
        return result;
    }

    /**
     * 排列：先确定第一个位置的情况，再确定第二个位置...以此类推
     *
     * @param chars  字符数组
     * @param start  当前下标
     * @param result
     */
    private void permutationInternal(char[] chars, int start, ArrayList<String> result) {
        if (start == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            //确定当前位置
            //交换
            char tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
            //当前位置后，确定下一个位置
            permutationInternal(chars, start + 1, result);
            //恢复
            tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
        }
    }

    // TODO: 2019/8/28 重复字符的情况-组合
}
