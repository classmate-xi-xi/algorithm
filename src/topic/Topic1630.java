package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ywx
 * @description 等差子数组
 * @Date: 2023/03/23
 */

public class Topic1630 {
    /**
     * 如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是等差数列
     * 更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i ， s[i+1] - s[i] == s[1] - s[0] 都成立
     *
     * @param nums [4,6,5,9,3,7]
     * @param l    [0,0,2]
     * @param r    [2,3,5]
     * @return [true, false, true]
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(arr);
            ans.add(isArithmeticSubArray(arr));
        }
        return ans;
    }

    /**
     * 判断是否是等差数列
     *
     * @param arr
     * @return
     */
    private boolean isArithmeticSubArray(int[] arr) {
        if (arr.length == 2) {
            return true;
        }
        int len = arr.length;
        if ((arr[len - 1] - arr[0]) % (len - 1) != 0) {
            return false;
        }
        for (int i = 2; i < len; i++) {
            if (arr[i] - arr[i - 1] != arr[1] - arr[0]) {
                return false;
            }
        }
        return true;
    }
}
