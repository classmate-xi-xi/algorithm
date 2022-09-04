package topic;

/**
 * @author: ywx
 * @description 二进制矩阵中的特殊位置
 * @Date: 2022/09/04
 */

public class Topic1582 {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] n = new int[row];
        int[] m = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    n[i]++;
                    m[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && n[i] == 1 && m[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Topic1582().numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}});
    }
}
