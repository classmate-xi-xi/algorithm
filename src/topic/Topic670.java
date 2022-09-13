package topic;

/**
 * @author: ywx
 * @description 最大交换
 * @Date: 2022/09/13
 */

public class Topic670 {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int max = num;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                char temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                max = Math.max(max, Integer.parseInt(new String(nums)));
                char temp1 = nums[i];
                nums[i] = nums[j];
                nums[j] = temp1;
            }
        }
        return max;
    }
}
