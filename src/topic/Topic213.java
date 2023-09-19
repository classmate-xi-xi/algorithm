package topic;

/**
 * @author: ywx
 * @description: 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
 * @date: 2023/9/17
 */
public class Topic213 {
    /**
     * 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *
     * @param nums [2,3,2]
     * @return 3
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 不能同时偷相邻的房屋,由于收尾相邻所以有两种边界
        // 0, nums.length - 2 和 1, nums.length - 1
        // 所以需计算两种边界的最大值
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        // 可所窃取的金额总数
        int first = nums[start];
        // 取可最大窃取金额数
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            // 寻找子问题的最优解
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
