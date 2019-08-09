package com.wangtao.mylibrary.algorithm.array;

/**
 * @author wangtao
 * @Description: offer(8): 旋转数组的最小值
 * @date 2019/8/9 15:27
 */

/**
 * 题目描述：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class RotateArrayMinValue {

    public static void main(String[] args) {
        RotateArrayMinValue roateArray = new RotateArrayMinValue();
        int[] arr = {2,1,2,2,2};
        int[] arr2 = {2,2,1,2};
        int[] arr3 = {1,2,3,4,5};
        int[] arr4 = {3,4,5,1,2};
        int[] arr5= {2};
        int[] arr6= {1,1,1,1,1,1};
        System.out.println(roateArray.minNumberInRotateArray(arr));
        System.out.println(roateArray.minNumberInRotateArray(arr2));
        System.out.println(roateArray.minNumberInRotateArray(arr3));
        System.out.println(roateArray.minNumberInRotateArray(arr4));
        System.out.println(roateArray.minNumberInRotateArray(arr5));
        System.out.println(roateArray.minNumberInRotateArray(arr6));
    }
    /**
     * 思路：
     * ①旋转后数组还是原先的排序顺序（特殊处理）
     * ②旋转后数组分为两个排序部分 （记住这个特性，二分查找就是依据这个缩小区间的）
     * <p>
     * 解法：（针对两个部分排序的）
     * ①：一次遍历，如果arr[i]>arr[i+1]，那么arr[i+1]就是最小值，时间复杂度O(n)
     * ②：二分查找
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //初始设置
        int l = 0;
        int h = array.length - 1;
        int m = l;

        while (array[l] >= array[h]) {//确保前半部分大于等于后半部分
            //缩小到相邻的两位数，最小值就是，后面那位，没必要再继续算了
            if (h - l == 1) {
                return array[h];
            }

            m = l + ((h - l) >> 1);//这里注意位运算（>>）的优先级较低，要加括号!

            //三个数相等，如：{2,2,1,2},{2,1,2,2,2}，这个时候是没办法确定区间的
            if (array[m] == array[l] && array[m] == array[h]) {
                int min = array[l];
                for (int i = l + 1; i <= h; i++) {
                    if (min > array[i]) {
                        min = array[i];
                        break;
                    }
                }
                return min;
            }
            //m下标值大于前面部分，说面要找的最小值在m下标之后
            if (array[m] >= array[l]) {
                l = m;
            }
            //同上理
            if (array[m] <= array[h]) {
                h = m;
            }

        }

        return array[m];
    }
}
