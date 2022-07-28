package topic;

import java.util.*;

/**
 * @author: ywx
 * @description 组合
 * @Date: 2022/07/28
 */

public class Topic77 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    private void backTrack(int n, int k, int start) {
        if (k == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backTrack(n, k, i + 1);
            track.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return result;
    }
}
