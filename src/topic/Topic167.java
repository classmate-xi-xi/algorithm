package topic;

/**
 * @author: ywx
 * @description 两数之和 II
 * 下标从 1 开始的整数数组 该数组已按 非递减顺序排列，请你从数组中找出满足相加之和等于目标数 target 的两个数
 * 你可以假设每个输入只对应唯一的答案 ，而且你 不可以 重复使用相同的元素
 * @Date: 2022/07/18
 */

public class Topic167 {

    int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
