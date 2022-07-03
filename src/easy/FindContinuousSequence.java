package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果我们知道起点 x 和终点 y ，那么 x 累加到 y 的和由求和公式可以知道是 (x+y)∗(y−x+1)/2 = target ，
 * 那么问题就转化为了是否存在一个正整数 y(y>x)，满足等式
 *
 * (x+y)∗(y−x+1)/2 = target
 *
 * 转化一下变成
 *
 * y2 + y − x2 + x − 2∗target = 0
 *
 * 这是一个关于 y 的一元二次方程，其中 a=1,b=1,c=直接套用求根公式即可 O(1) 解得 y，判断是否整数解需要满足两个条件：
 * 判别式 b^2 - 4ac 开根需要为整数
 * 最后的求根公式的分子需要为偶数，因为分母为 2
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target){
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int x = 1; x <= limit; ++x) {
            long delta = 1 - 4 * (x - (long) x * x - 2 * target);
            if (delta < 0) {
                continue;
            }
            int delta_sqrt = (int) Math.sqrt(delta + 0.5);
            if ((long) delta_sqrt * delta_sqrt == delta && (delta_sqrt - 1) % 2 == 0) {
                int y = (-1 + delta_sqrt) / 2; // 另一个解(-1-delta_sqrt)/2必然小于0，不用考虑
                if (x < y) {
                    int[] res = new int[y - x + 1];
                    for (int i = x; i <= y; ++i) {
                        res[i - x] = i;
                    }
                    vec.add(res);
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    public static void main(String[] args) {
        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));

    }
}
