package topic;

import java.util.Arrays;

/**
 * @author: ywx
 * @description 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @Date: 2022/07/18
 */

public class Topic189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int left = 0, right = nums.length - 1;
        rotate1(nums, left, right);
        rotate1(nums, left, k - 1);
        rotate1(nums, k, right);
    }

    public void rotate1(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        new Topic189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(3 % 7);
    }
}
