package structure.sort;

import java.util.Arrays;

/**
 * @author: ywx
 * @description 快速排序
 * @Date: 2022/08/05
 */

public class QuickSort {
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

    public static void main(String[] args) {
        int[] r = new int[]{22, 3, 121, 44, 34, 22};
        new QuickSort().quickSort(r, 0, r.length - 1);
        for (int i : r) {
            System.out.println(i);
        }
    }
}
