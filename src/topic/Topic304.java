package topic;

/**
 * @author: ywx
 * @description 二维区域和检索 - 矩阵不可变
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1,col1) ，右下角 为 (row2,col2) 。
 * 实现 NumMatrix 类：
 * <p>
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)
 * 返回左上角 (row1,col1)、右下角(row2,col2)所描述的子矩阵的元素总和
 * @Date: 2022/07/17
 */

public class Topic304 {
    private int[][] preNum;

    //NumMatrix
    public Topic304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        preNum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preNum[i][j] = preNum[i - 1][j] + preNum[i][j - 1] + matrix[i - 1][j - 1] - preNum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNum[row2 + 1][col2 + 1] - preNum[row1][col2 + 1] - preNum[row2 + 1][col1] +
                preNum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        Topic304 t = new Topic304(num);
        System.out.println(t.sumRegion(2,1,4,3));
    }
}
