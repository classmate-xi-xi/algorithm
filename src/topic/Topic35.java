package topic;

/**
 * @author: ywx
 * @description 搜索插入位置--二分查找
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Date: 2022/07/17
 */

public class Topic35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Topic35 t = new Topic35();
        System.out.println(t.searchInsert(new int[]{1,3,5,6},2));
    }
}
