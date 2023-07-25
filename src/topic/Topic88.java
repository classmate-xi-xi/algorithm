package topic;

import java.util.Arrays;

/**
 * @author: ywx
 * @description 合并两个有序数组
 * @Date: 2023/04/28
 */

public class Topic88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
