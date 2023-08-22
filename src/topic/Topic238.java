package topic;

/**
 * @author: ywx
 * @description 除自身以外数组的乘积
 * @Date: 2023/08/22
 */

public class Topic238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length];
        int temp = 1;
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            ans[i] *= temp;
        }
        return ans;
    }
}
