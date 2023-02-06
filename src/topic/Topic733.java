package topic;

/**
 * @author: ywx
 * @description 图像渲染
 * @Date: 2022/07/27
 */

public class Topic733 {
    void fill(int[][] image, int origColor, int newColor, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] != origColor){
            return;
        }
        if (image[sr][sc] == -1){
            return;
        }
        image[sr][sc] = -1;
        fill(image, origColor, newColor, sr - 1, sc); // 上
        fill(image, origColor, newColor, sr + 1, sc); // 下
        fill(image, origColor, newColor, sr, sc - 1); // 左
        fill(image, origColor, newColor, sr, sc + 1); // 右
        image[sr][sc] = newColor;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, image[sr][sc], color, sr, sc);
        return image;
    }

}
