package topic;

/**
 * @author: ywx
 * @description 最长回文子串
 * @Date: 2022/08/01
 */

public class Topic5 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中⼼的最⻓回⽂⼦串
            String s1 = palindrome(s, i, i);
            //以 s[i]  和 s[i+1] 为中⼼的最⻓回⽂⼦串
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
