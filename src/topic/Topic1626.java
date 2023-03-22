package topic;

import java.util.Arrays;

/**
 * @author: ywx
 * @description 无矛盾的最佳球队
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队
 * 如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄
 * 请你返回 所有可能的无矛盾球队中得分最高那支的分数
 * @Date: 2023/03/22
 */

public class Topic1626 {
    /**
     * @param scores [1,3,5,10,15]
     * @param ages   [1,2,3,4,5]
     * @return 34
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
