package topic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ywx
 * @description 从两个数字数组里生成最小数字
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 * @Date: 2023/09/05
 */

public class Topic2605 {
    /**
     * 找两个数组中有没有相同的数字，有返回最小值；没有返回两个数组中的最小值能够组成的最小数字
     *
     * @param nums1 [4,1,3]
     * @param nums2 [5,7]
     * @return 15
     */
    public int minNumber(int[] nums1, int[] nums2) {
        int minA = 9;
        int minB = 9;
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            minA = Math.min(i, minA);
            set.add(i);
        }

        int contain = 10;
        for (int i : nums2) {
            if (set.contains(i)) {
                contain = Math.min(i, contain);
            }
            minB = Math.min(i, minB);
        }

        if (contain != 10) {
            return contain;
        }
        return Math.min(minA * 10 + minB, minB * 10 + minA);
    }
}
