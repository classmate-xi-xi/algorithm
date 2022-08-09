package topic;

/**
 * @author: ywx
 * @description 逐步求和得到正数的最小值
 * @Date: 2022/08/09
 */

public class Topic1413 {
    public int minStartValue(int[] nums) {
        int sum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(sum, minSum);
        }
        return 1 - minSum;
    }

    public static void main(String[] args) {
        System.out.println(new Topic1413().minStartValue(new int[]{-3, 2, -3}));
    }
}
