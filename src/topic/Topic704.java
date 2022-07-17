package topic;

/**
 * @author: ywx
 * @description 二分查找
 * @Date: 2022/07/17
 */

public class Topic704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []num = new int[]{1,2,4,7,9};
        System.out.println(new Topic704().search(num, 9));
    }
}
