package structure.sort;

/**
 * @author: ywx
 * @description 归并排序
 * 先把左半边数组排好序，再把右半边数组排好序，然后把两半数组合并
 * @Date: 2022/08/24
 */

public class MergeSort {
    /**
     * 用于辅助合并两个有序数组
     */
    private static int[] temp;

    /**
     * 开辟对应的内存空间
     * 借助了额外空间，可以实现「稳定排序」
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        temp = new int[nums.length];
        //排序整个数组(原地修改)
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        //单个元素不排序
        if (lo == hi) {
            return;
        }
        int mid = (lo + hi) >> 1;
        //对左半边数组排序 nums[lo..mid]
        sort(nums, lo, mid);
        //对右半边数组排序 nums[mid+1..hi]
        sort(nums, mid + 1, hi);
        //合并两个有序数组，使 nums[lo..hi] 有序
        merge(nums, lo, mid, hi);

    }

    /**
     * 将 nums[lo..mid] 和 nums[mid+1..hi] 这两个有序数组合并成一个有序数组
     *
     * @param nums
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(int[] nums, int lo, int mid, int hi) {
        //copy nums到辅助数组temp中
//        for (int i = lo; i <=hi ; i++) {
//            temp[i] = nums[i];
//        }
        if (hi + 1 - lo >= 0) {
            System.arraycopy(nums, lo, temp, lo, hi + 1 - lo);
        }
        //双指针技巧，合并两个有序数组
        int l = lo, m = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (l == mid + 1) {
                //左半边数组已全部被合并
                nums[p] = temp[m];
                m++;
            } else if (m == hi + 1) {
                //右半边数组已全部被合并
                nums[p] = temp[l];
                l++;
            } else if (temp[l] > temp[m]) {
                nums[p] = temp[m];
                m++;
            } else {
                // temp[l] <= temp[m]
                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                // 所以可以交换if else 的顺序
                nums[p] = temp[l];
                l++;
            }
        }
    }
}
