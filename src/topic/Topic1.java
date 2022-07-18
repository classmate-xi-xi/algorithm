package topic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ywx
 * 两数之和
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Topic1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //非有序数组 链表不适用双指针！
    public int[] twoSum11(int[] nums, int target) {
        int n = nums.length - 1, l = 0;
        while (l < n) {
            if (nums[l] + nums[n] == target) {
                return new int[]{l, n};
            } else if (nums[l] + nums[n] < target) {
                l++;
            } else if (nums[l] + nums[n] > target) {
                n--;
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 哈希表实现
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
