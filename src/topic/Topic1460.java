package topic;

import java.util.Arrays;

/**
 * @author: ywx
 * @description 通过翻转子数组使两个数组相等
 * @Date: 2022/08/24
 */

public class Topic1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        quickSort(target,0, target.length-1);
        quickSort(arr,0,arr.length-1);
        return Arrays.equals(target, arr);
    }
    public void quickSort(int[] nums, int left, int right) {
        int low = left;
        int high = right;
        if (low >= high) {
            return;
        }
        int mid = nums[(low + high) / 2];

        while (low <= high) {
            while (nums[low] < mid) {
                low++;
            }
            while (nums[high] > mid) {
                high--;
            }
            if (low <= high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        quickSort(nums, left, high);
        quickSort(nums, low, right);
    }
}
