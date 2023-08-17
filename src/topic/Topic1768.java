package topic;

/**
 * @author: ywx
 * @description 交替合并字符串
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长
 * 就将多出来的字母追加到合并后字符串的末尾
 * 返回 合并后的字符串 。
 * @Date: 2023/08/17
 */

public class Topic1768 {
    /**
     * word1：  a   b   c
     * word2：    p   q   r
     * 合并后：  a p b q c r
     *
     * @param word1 "abc"
     * @param word2 "pqr"
     * @return "apbqcr"
     */
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                ans.append(word1.charAt(i));
                i++;
            }
            if (j < n) {
                ans.append(word2.charAt(j));
                j++;
            }
        }
        return ans.toString();
    }
}
