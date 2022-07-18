package topic;

/**
 * @author: ywx
 * @description 移除元素
 * @Date: 2022/07/18
 */

public class Topic27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                //先赋值再++
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        //slow
        return slow;
    }
}
