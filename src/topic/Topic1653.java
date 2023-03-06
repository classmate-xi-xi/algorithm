package topic;

/**
 * @author: ywx
 * @description 使字符串平衡的最少删除次数
 * 给你一个字符串s，它仅包含字符'a' 和'b' 。
 * 你可以删除s中任意数目的字符，使得s 平衡。当不存在下标对(i,j)满足i < j ，且s[i] = 'b' 的同时s[j]= 'a' ，此时认为 s 是 平衡 的。
 * 请你返回使 s平衡的 最少删除次数。
 * @Date: 2023/03/06
 */

public class Topic1653 {
    public int minimumDeletions(String s) {
        int len = s.length();
        int ans = 0;
        int b = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'b') {
                b++;
            } else {
                ans = Math.min(ans + 1, b);
            }
        }
        return ans;
    }
}
