package topic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ywx
 * @description 找到 K 个最接近的元素
 * @Date: 2022/08/25
 */

public class Topic658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        // 需要删除几个数
        int del = len - k;
        while (del > 0) {
            // 比较，收缩两边边界
            if (Math.abs((x - arr[left])) <= Math.abs(x - arr[right])) {
                left++;
            } else {
                right--;
            }
            del--;
        }
        // 从 left 开始到 left + k 的数即最靠近x的k个数
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
