package topic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: ywx
 * @description 可能的二分法
 * @Date: 2022/10/16
 */

public class Topic886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] lists = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            lists[p[0]].add(p[1]);
            lists[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int t = queue.poll();
                    for (int next : lists[t]) {
                        if (color[next] > 0 && color[next] == color[t]) {
                            return false;
                        }
                        if (color[next] == 0) {
                            color[next] = 3 ^ color[t];
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }

}
