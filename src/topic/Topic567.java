package topic;

import java.util.HashMap;

/**
 * @author: ywx
 * @description 字符串的排列
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含s1的排列。如果是，返回 true；否则，返回 false 。
 * <p>
 * 换句话说，s1的排列之一是s2的子串
 * @Date: 2022/07/23
 */

public class Topic567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int right = 0, left = 0;
        // 当我们发现某个字符在 window 的数量满足了 need 的需要，就要更新 valid，表示有一个字符已经满足要求
        int valid = 0;
        //添加需要查找的字符
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    valid--;
                }
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
        }
        return false;
    }

}
