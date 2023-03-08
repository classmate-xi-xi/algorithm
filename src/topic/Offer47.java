package topic;

/**
 * @author: ywx
 * @description 礼物的最大价值
 * @Date: 2023/03/08
 */

public class Offer47 {
    /**
     * @param grid [
     *             [1,3,1],
     *             [1,5,1],
     *             [4,2,1]
     *             ]
     * @return 1→3→5→2→1 可以拿到最多价值的礼物 12
     */
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int i = new Offer47().maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(i);
    }
}
