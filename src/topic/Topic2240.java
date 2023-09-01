package topic;

/**
 * @author: ywx
 * @description 买钢笔和铅笔的方案数
 * 给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格
 * 你可以花费你部分或者全部的钱，去买任意数目的两种笔。
 * 请你返回购买钢笔和铅笔的 不同方案数目 。
 * @Date: 2023/09/01
 */

public class Topic2240 {
    /**
     * 一支钢笔的价格为 10 ，一支铅笔的价格为 5 。
     * - 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
     * - 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
     * - 如果你买 2 支钢笔，那么你没法买任何铅笔。
     * 所以买钢笔和铅笔的总方案数为 5 + 3 + 1 = 9 种。
     *
     * @param total 20
     * @param cost1 10
     * @param cost2 5
     * @return 9
     */
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 < cost2) {
            return waysToBuyPensPencils(total, cost1, cost2);
        }
        long res = 0;
        long cnt = 0;
        while (cost1 * cnt <= total) {
            res += (total - cnt * cost1) / cost2 + 1;
            cnt++;
        }
        return res;
    }
}
