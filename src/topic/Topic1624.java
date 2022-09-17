package topic;

import java.util.Arrays;

/**
 * @author: ywx
 * @description 两个相同字符之间的最长子字符串
 * @Date: 2022/09/17
 */

public class Topic1624 {
//    public int maxLengthBetweenEqualCharacters(String s) {
//        int[] idxs = new int[26];
//        Arrays.fill(idxs, 310);
//        int n = s.length(), ans = -1;
//        for (int i = 0; i < n; i++) {
//            int u = s.charAt(i) - 'a';
//            idxs[u] = Math.min(idxs[u], i);
//            ans = Math.max(ans, i - idxs[u] - 1);
//        }
//        return ans;
//    }
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        for (char c = 'a'; c <= 'z'; c++){
            ans = Math.max(ans, s.lastIndexOf(c) - s.indexOf(c) - 1);
        }
        return ans;
    }
}
