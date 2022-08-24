package structure.sort;

/**
 * @author: ywx
 * @description 堆排序
 * @Date: 2022/08/24
 */

public class HeapSort {
    public void sort(int[] nums) {
        int len = nums.length;
        // 将数组整理成堆
        heap(nums, len);
        // 循环不变量：区间 [0, i] 堆有序
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // 逐步减少堆有序的部分
            i--;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, i);
        }
    }

    /**
     * 将数组整理成堆（堆有序）
     *
     * @param nums
     */
    private void heap(int[] nums, int len) {
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
        for (int i = (len - 1) >> 1; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    /**
     * @param nums
     * @param index 当前下沉元素的下标
     * @param end   [0, end] 是 nums 的有效部分
     */
    private void siftDown(int[] nums, int index, int end) {
        while (2 * index + 1 <= end) {
            int j = 2 * index + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[index]) {
                swap(nums, j, index);
            } else {
                break;
            }
            index = j;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] x = new int[]{21, 32, 11, 41, 2222, 55, 12, 1, 412, 6};
        new HeapSort().sort(x);
        for (int xx : x) {
            System.out.println(xx);
        }
    }
}
