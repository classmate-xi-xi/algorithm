package topic;

import java.util.Arrays;

/**
 * @author: ywx
 * @description 删除某些元素后的数组均值
 * @Date: 2022/09/14
 */

public class Topic1619 {
    public double trimMean(int[] arr) {
        double ans = 0.0;
        int len = arr.length;
        int max = len * 19 / 20;
        int min = len / 20;
        Arrays.sort(arr);
        for (int i = min; i < max; i++) {
            ans += arr[i];
        }
        return ans / (len * (9.0 / 10.0));
    }
}
