package structure.sort;

/**
 * @author: ywx
 * @description 冒泡排序
 * @Date: 2022/08/05
 */

public class BubbleSort {
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] i = new int[]{2, 3, 1, 777, 77, 221, 455};
        new BubbleSort().bubbleSort(i);
        for (int i1 : i) {
            System.out.println(i1);
        }
    }
}
