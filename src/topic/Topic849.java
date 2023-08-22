package topic;

/**
 * @author: ywx
 * @description 到最近的人的最大距离
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 * @Date: 2023/08/22
 */

public class Topic849 {
    public static void main(String[] args) {
        new Topic849().maxDistToClosest(new int[]{0, 0, 1, 0});
    }

    /**
     * 思路 求左右最大连续0的个数
     * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
     * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
     * 因此，他到离他最近的人的最大距离是 2 。
     *
     * @param seats [1,0,0,0,1,0,1]；[1,0,0,0]
     * @return 2；3
     */
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int ans = 0;
        while (max < seats.length && seats[max] == 0) {
            max++;
        }
        for (int i = max + 1; i < seats.length; i++) {
            max = Math.max(max, (ans + 1) >> 1);
            ans = seats[i] == 1 ? 0 : ans + 1;
        }
        return Math.max(max, ans);
    }
}
