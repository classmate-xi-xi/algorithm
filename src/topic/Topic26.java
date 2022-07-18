package topic;

/**
 * @author: ywx
 * @description 删除有序数组中的重复项
 * @Date: 2022/07/18
 */

public class Topic26 {
    //--双指针
    int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {

    }
}
