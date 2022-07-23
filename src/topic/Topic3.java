package topic;

import java.util.HashMap;

/**
 * @author: ywx
 * @description 无重复字符的最长子串
 * @Date: 2022/07/23
 */

public class Topic3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int right = 0, left = 0;
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}
