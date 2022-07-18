package topic;

/**
 * @author: ywx
 * @description 移动零 --双指针
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @Date: 2022/07/18
 */

public class Topic283 {
    /**
     * 找0元素移除 再将后面的空缺元素赋0
     */
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

    public void moveZeroes(int[] nums) {
        int p = removeElement(nums, 0);
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}
