package topic;

/**
 * @author: ywx
 * @description: 检查骑士巡视方案
 * 骑士在一张 n x n 的棋盘上巡视。在 有效 的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，
 * 中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 * 骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
 * @date: 2023/9/13
 */
public class Topic2596 {
    /**
     * “日”字行走
     *
     * @param grid [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
     * @return true
     */
    public boolean checkValidGrid(int[][] grid) {
        // 骑士的行动是从下标 0 开始的 需要满足 grid[0][0]=0
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        // 存储单元格的访问顺序 indices[i] 表示骑士在经过第 i−1 次跳跃后的位置
        // 由于 indices[i]是一次跳跃的起点，indices[i+1]是该次跳跃的终点，则依次检测每一次跳跃的行动路径是否为「日」字形
        // 需要满足以下条件
        // ∣ indices[i][0] − indices[i+1][0] ∣ = 1, ∣ indices[i][1] − indices[i+1][1] ∣ = 2
        // ∣ indices[i][0] − indices[i+1][0] ∣ = 2, ∣ indices[i][1] − indices[i+1][1] ∣ = 1
        int[][] indices = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                indices[grid[i][j]][0] = i;
                indices[grid[i][j]][1] = j;
            }
        }
        for (int i = 1; i < n * n; i++) {
            int dx = Math.abs(indices[i][0] - indices[i - 1][0]);
            int dy = Math.abs(indices[i][1] - indices[i - 1][1]);
            // 为了方便计算，我们只需检测 ∣x1−x2∣×∣y1−y2∣ 是否等于 2 即可
            // 如果所有跳跃路径均合法则返回 true否则返回 false
            if (dx * dy != 2) {
                return false;
            }
        }
        return true;
    }
}
