package topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ywx
 * @description: 可以攻击国王的皇后
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 * 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
 * @date: 2023/9/14
 */
public class Topic1222 {
    /**
     * 解释：
     * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
     * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
     * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
     * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
     * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
     * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
     *
     * @param queens [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
     * @param king   [0,0]
     * @return [[0, 1], [1, 0], [3, 3]]
     */
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Map<Integer, int[]> candidates = new HashMap<>();
        int kx = king[0];
        int ky = king[1];
        for (int[] queen : queens) {
            int qx = queen[0];
            int qy = queen[1];
            int x = qx - kx;
            int y = qy - ky;
            if (x == 0 || y == 0 || Math.abs(x) == Math.abs(y)) {
                int dx = sgn(x);
                int dy = sgn(y);
                int key = dx * 10 + dy;
                int sum = Math.abs(x) + Math.abs(y);
                if (!candidates.containsKey(key) || candidates.get(key)[2] > sum) {
                    candidates.put(key, new int[]{queen[0], queen[1], sum});
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : candidates.entrySet()) {
            int[] value = entry.getValue();
            List<Integer> posList = new ArrayList<>();
            posList.add(value[0]);
            posList.add(value[1]);
            ans.add(posList);
        }
        return ans;
    }

    private int sgn(int num) {
        return Integer.compare(num, 0);
    }
}
