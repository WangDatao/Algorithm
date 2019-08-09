package com.wangtao.mylibrary.algorithm.string;

/**
 * @author wangtao
 * @Description: Offer<3>-字符串（数组）中空格的替换为'%20'
 * @date 2019/8/8 11:40
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        //test 1
        String testStr = "We Are Happy";
        System.out.println(replaceSpace(new StringBuffer(testStr)));
        char[] chars = testStr.toCharArray();
        //test 2
        char[] longChars = new char[20];
        for (int i = 0; i < chars.length; i++) {
            longChars[i] = chars[i];
        }
        int count = replaceSpace(longChars, chars.length);
        if(count >0){
            System.out.println(new String(longChars , 0 , count));
        }
    }

    /**
     * 1.同一个数组内，用两个下标操作的算法很多
     * 2.从后往前操作数组，避免多次移动数据，降低时间复杂度
     * @param charArr
     * @param usedLength
     * @return
     */
    public static int replaceSpace(char[] charArr, int usedLength) {

        if (charArr == null || usedLength > charArr.length) {
            return -1;
        }
        //记录空
        int spaceCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (charArr[i] == ' ') {
                spaceCount++;
            }
        }
        //空格替换后的长度
        int newLength = spaceCount * 2 + usedLength;
        if (newLength > charArr.length) {
            return -1;
        }
        int usedIndex = usedLength-1;
        int newIndex = newLength-1;
        //从后往前，两个下标，操作
        while (usedIndex >= 0) {
            if (charArr[usedIndex] == ' ') {
                charArr[newIndex--] = '0';
                charArr[newIndex--] = '2';
                charArr[newIndex--] = '%';
                usedIndex--;
            } else {
                charArr[newIndex--] = charArr[usedIndex--];
            }
        }

        return newLength;
    }

    /**
     * 给的是StringBuffer，没什么好说。。。
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        int oldLength = str.length();
        if (str == null || oldLength == 0) {
            return "";
        }
        StringBuffer newSb = new StringBuffer();
        for (int i = 0; i < oldLength; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                newSb.append("%20");
            } else {
                newSb.append(c);
            }
        }
        return newSb.toString();
    }

}
