package topic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: ywx
 * @description
 * 给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示
 * 其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。
 * 多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。
 * 指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数
 * 即使一分钟内执行多个操作，也只能按一分钟计数
 * 请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer
 * 对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。
 * 返回上面描述的答案数组 answer
 * @Date: 2023/01/20
 */

public class Topic1817 {
    /**
     * @param logs -> [[0,5],[1,2],[0,2],[0,5],[1,3]]
     * @param k    -> 5
     * @return -> [0,2,0,0,0]
     * 解释：
     * ID=0 的用户执行操作的分钟分别是：5 、2 和 5 。因此，该用户的用户活跃分钟数为 2（分钟 5 只计数一次）
     * ID=1 的用户执行操作的分钟分别是：2 和 3 。因此，该用户的用户活跃分钟数为 2
     * 2 个用户的用户活跃分钟数都是 2 ，answer[2] 为 2 ，其余 answer[j] 的值都是 0
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>(logs.length);
        for (int[] log : logs) {
            map.computeIfAbsent(log[0], key -> new HashSet<>()).add(log[1]);
        }
        int[] ans = new int[k];
        for (Set<Integer> v : map.values()) {
            ans[v.size() - 1] += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Topic1817().findingUsersActiveMinutes(new int[][]{{0, 5},{1, 2},{0, 2},{0, 5},{1, 3}},5);
    }
}
