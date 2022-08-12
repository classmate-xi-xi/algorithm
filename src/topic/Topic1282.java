package topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ywx
 * @description 用户分组
 * @Date: 2022/08/12
 */

public class Topic1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            //map.computeIfAbsent(groupSize, k -> new ArrayList<>()).add(i); 等同
            map.computeIfAbsent(groupSize, ArrayList::new).add(i);
            if (map.get(groupSize).size() == groupSize) {
                ans.add(map.put(groupSize, new ArrayList<>()));
            }
        }
        return ans;
    }
}
