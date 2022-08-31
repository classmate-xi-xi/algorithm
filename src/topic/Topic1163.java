package topic;

/**
 * @author: ywx
 * @description 按字典序排在最后的子串
 * 输入：s = "abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * @Date: 2022/08/31
 */

public class Topic1163 {
    public String lastSubstring(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int l = 0, r = 1, k = 0;
        while (l < n && r < n && k < n) {
            if (c[l + k] == c[r + k]) {
                k++;
            } else {
                if (c[l + k] > c[r + k]) {
                    r += k + 1;
                } else {
                    l += k + 1;
                }
                if (l == r) {
                    r++;
                }
                k = 0;
            }
            if (Math.max(l, r) + k >= n) {
                break;
            }
        }
        int p = Math.min(l, r);
        return s.substring(p, n);
    }
}
