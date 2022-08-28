package topic;

/**
 * @author: ywx
 * @description 重新排列数组
 * @Date: 2022/08/29
 */

public class Topic1470 {
    public int[] shuffle(int[] nums, int n) {
        int index = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }
        return result;
    }

}
