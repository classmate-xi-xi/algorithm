package topic;

/**
 * @author: ywx
 * @description 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k
 * 使得 nums[i] < nums[j] < nums[k] 返回 true ；否则，返回 false
 * @Date: 2023/08/23
 */

public class Topic334 {

    /**
     * @param nums [1,2,3,4,5]
     * @return true
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = nums[0];
        int max = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                return true;
            } else if (num > first) {
                max = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
