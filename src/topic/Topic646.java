package topic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ywx
 * @description 最长数对链
 * 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 * @Date: 2022/09/03
 */

public class Topic646 {
    /**
     * 输入：[[1,2], [2,3], [3,4]]
     * 输出：2
     * 解释：最长的数对链是 [1,2] -> [3,4]
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int[] p = new int[len];
        Arrays.fill(p, 1);
        int i = 0;
        for (int[] ints : pairs) {
            for (int j = 0; j < i; j++) {
                if (ints[0] > pairs[j][1]) {
                    p[i] = Math.max(p[i], p[j] + 1);
                }
            }
            i++;
        }
        return p[len - 1];
    }

    public int findLongestChain1(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int ans = 0;

        // 题目隐藏的数据范围是[-1000,1000]
        // 如果数据范围扩充到Integer.MIN_VALUE，则不能使用这个值
        int last = Integer.MIN_VALUE;
        for (int[] p : pairs) {
            if (p[0] > last) {
                ans++;
                last = p[1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] p = new int[][]{{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}};
        new Topic646().findLongestChain(p);

    }
}
