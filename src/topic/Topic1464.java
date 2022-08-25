package topic;

/**
 * @author: ywx
 * @description 数组中两元素的最大乘积
 * @Date: 2022/08/26
 */

public class Topic1464 {
    public int maxProduct(int[] nums) {
        /**
         * Arrays.sort(nums);
         * return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
         */
        int max1 = 0;
        int max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max2 - 1) * (max1 - 1);
    }
}
