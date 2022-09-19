package topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: ywx
 * @description 按照频率将数组升序排序
 * @Date: 2022/09/19
 */

public class Topic1636 {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((a, b) -> {
            int a1 = map.get(a);
            int b1 = map.get(b);
            return a1 != b1 ? a1 - b1 : b - a;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
