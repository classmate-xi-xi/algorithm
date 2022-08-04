package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ywx
 * @description 非递增顺序的最小子序列
 * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和
 * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列
 * @Date: 2022/08/04
 */

public class Topic1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        Arrays.sort(nums);
        int l = 0;
        for (int i = nums.length - 1; i >=0; i--) {
            result.add(nums[i]);
            l +=nums[i];
            if (l > (sum/2)) {
                break;
            }
        }
        return result;
    }
}
