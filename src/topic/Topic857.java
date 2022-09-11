package topic;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: ywx
 * @description 雇佣 K 名工人的最低成本
 * @Date: 2022/09/11
 */

public class Topic857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        double result = -1;
        Integer[] ratioIndex = new Integer[len];
        // 大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // 存储最小比率的索引
        for (int i = 0; i < len; i++) {
            ratioIndex[i] = i;
        }
        // 排序最小比率的索引
        Arrays.sort(ratioIndex, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return wage[o1] * quality[o2] - wage[o2] * quality[o1];
            }
        });
        int total = 0;
        for (int idx : ratioIndex) {
            total += quality[idx];
            pq.add(quality[idx]);
            if (pq.size() > k) {
                total -= pq.poll();
            }
            if (pq.size() == k) {
                double cur = (double) total * wage[idx] / quality[idx];
                result = result < 0 ? cur : Math.min(result, cur);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Topic857().mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2);
    }
}
