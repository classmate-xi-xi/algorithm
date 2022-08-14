package topic;

/**
 * @author: ywx
 * @description 分割字符串的最大得分
 * 分割字符串的得分为 左子字符串中 0 的数量加上 右子字符串中 1 的数量
 * @Date: 2022/08/14
 */

public class Topic1422 {
    public int maxScore(String s) {
        int ans = 0;
        int c0 = 0, c1 = 0;
        //  统计1
        for (char c : s.toCharArray()) {
            if (c == '1') {
                c1++;
            }
        }
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '0') {
                c0++;
            } else {
                c1--;
            }
            ans = Math.max(ans, c0 + c1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Topic1422().maxScore("00111");
    }
}
