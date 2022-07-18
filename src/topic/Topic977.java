package topic;

import java.util.Arrays;

/**
 * @author: ywx
 * @description 有序数组的平方
 * 一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序
 * @Date: 2022/07/18
 */

public class Topic977 {
    //猪脑解题法 秒
    public int[] sortedSquares(int[] nums) {
        int[] p = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            p[i] = nums[i] * nums[i];
        }
        Arrays.sort(p);
        return p;
    }

    //双指针
    //原数组中的元素 平方最大值一定产生在原数组的最左边或者最右边
    public int[] sortedSquares1(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] p = new int[nums.length];
        // 得到元素值平方值，从新数组最后位置开始写
        int write = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                p[write] = nums[left] * nums[left];
                left++;
                write--;
            } else {
                p[write] = nums[right] * nums[right];
                right--;
                write--;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int p[] = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new Topic977().sortedSquares(p)));
    }

}
