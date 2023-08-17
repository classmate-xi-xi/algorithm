package topic;

/**
 * @author: ywx
 * @description 字符串的最大公因子
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 * @Date: 2023/08/17
 */

public class Topic1071 {
    /**
     * @param str1 "ABCABC"
     * @param str2 "ABC"
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        int n = str2.length();
        int m = str1.length();
        int min = Math.min(n, m);
        for (int i = min; i >= 1; i--) {
            if (n % i == 0 || m % i == 0) {
                String suffix = str1.substring(0, i);
                if (check(suffix, str1) && check(suffix, str2)) {
                    return suffix;
                }
            }
        }
        return "";

    }

    private boolean check(String suffix, String s) {
        int lenS = s.length() / suffix.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= lenS; ++i) {
            ans.append(suffix);
        }
        return ans.toString().equals(s);
    }

}
