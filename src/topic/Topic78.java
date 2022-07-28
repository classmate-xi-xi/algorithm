package topic;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: ywx
 * @description 子集
 * @Date: 2022/07/28
 */

public class Topic78 {
    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    private void backTrack(int[] nums, int i) {
        res.add(new LinkedList<>(track));
        for (int j = i; j < nums.length; j++) {
            track.addLast(nums[i]);
            backTrack(nums, i + 1);
            track.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return res;
    }
}
