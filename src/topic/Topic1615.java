package topic;

/**
 * @author: ywx
 * @description 最大网络秩
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。
 * 每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。
 * 如果存在一条道路直接连接这两座城市，则这条道路只计算 一次
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩
 * @Date: 2023/03/15
 */

public class Topic1615 {
    /**
     * @param n     n = 4,
     * @param roads roads = [[0,1],[0,3],[1,2],[1,3]]
     *              城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次
     * @return 4 (0 -> 1,0 -> 3,1 -> 2,1 -> 3)
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] g = new int[n][n];
        int[] count = new int[n];
        for (int[] r : roads) {
            int a = r[0];
            int b = r[1];
            g[a][b] = 1;
            g[b][a] = 1;
            ++count[a];
            ++count[b];
        }
        int ans = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                ans = Math.max(ans, count[a] + count[b] - g[a][b]);
            }
        }
        return ans;
    }
}
