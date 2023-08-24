package topic;

/**
 * @author: ywx
 * @description 统计参与通信的服务器
 * @Date: 2023/08/24
 */

public class Topic1267 {
    /**
     * @param grid [[1,0],[0,1]]
     * @return 0
     */
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 不能 >= 1
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
