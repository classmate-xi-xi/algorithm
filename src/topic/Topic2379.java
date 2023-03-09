package topic;

/**
 * @author: ywx
 * @description 得到 K 个黑块的最少涂色次数
 * @Date: 2023/03/09
 */

public class Topic2379 {
    /**
     *
     * @param blocks blocks = "WBBWWBBWBW"
     * @param k k = 7
     * @return 3
     */
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        while (r < k) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            r++;
        }
        int res = cnt;
        while (r < blocks.length()) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            cnt -= blocks.charAt(l) == 'W' ? 1 : 0;
            res = Math.min(res, cnt);
            l++;
            r++;
        }
        return res;
    }
}
