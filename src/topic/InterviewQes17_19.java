package topic;

/**
 * @author: ywx
 * @description 面试题 17.19. 消失的两个数字
 * 示例 1:
 *
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 *
 * 输入: [2,3]
 * 输出: [1,4]
 * @Date: 2022/09/26
 */

public class InterviewQes17_19 {
    public int[] missingTwo(int[] nums) {
        // 原数组长度为 +2
        int totalLength = nums.length + 2;
        // 数组数字的总和
        int totalSum = ((totalLength + 1) * totalLength) >> 1;
        for (int num : nums) {
            totalSum -= num;
        }
        // 中心点
        int missingHalf = totalSum >> 1;
        int missingHalfSum = ((missingHalf + 1) * missingHalf) >> 1;
        for (int num : nums) {
            if (num <= missingHalf) {
                missingHalfSum -= num;
            }
        }
        return new int[]{missingHalfSum, totalSum - missingHalfSum};
    }
}
