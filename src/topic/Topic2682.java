package topic;

import java.util.stream.IntStream;

/**
 * @author: ywx
 * @description 找出转圈游戏输家
 * @Date: 2023/08/16
 */

public class Topic2682 {
    /**
     * @param n n 个朋友在玩游戏 n = 5
     * @param k 顺时针方向 k 步 k = 2
     * @return [4, 5]
     * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 2 步的玩家 —— 第 3 个朋友。
     * 2）第 3 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 2 个朋友。
     * 3）第 2 个朋友将球传给距离他顺时针方向 6 步的玩家 —— 第 3 个朋友。
     * 4）第 3 个朋友接到两次球，游戏结束。
     */
    public static int[] circularGameLosers(int n, int k) {
        int[] friends = new int[n];
        int current = 0;
        int cnt = 1;
        while (friends[current] < 1) {
            friends[current]++;
            current += (cnt * k);
            cnt++;
            current %= n;
        }
        return IntStream.range(1, n + 1).filter(i -> friends[i - 1] == 0).toArray();
    }
}
