package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author: ywx
 * @description 将数组和减半的最少操作次数
 * 给你一个正整数数组nums。每一次操作中，你可以从nums中选择任意一个数并将它减小到恰好一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
 * 请你返回将 nums数组和至少减少一半的最少操作数。
 * @Date: 2023/07/25
 */

public class Topic2208 {
    /**
     * 解释：初始 nums 的和为 5 + 19 + 8 + 1 = 33 。
     * 以下是将数组和减少至少一半的一种方法：
     * 选择数字 19 并减小为 9.5 。
     * 选择数字 9.5 并减小为 4.75 。
     * 选择数字 8 并减小为 4 。
     * 最终数组为 [5, 4.75, 4, 1] ，和为 5 + 4.75 + 4 + 1 = 14.75 。
     * nums 的和减小了 33 - 14.75 = 18.25 ，减小的部分超过了初始数组和的一半，18.25 >= 33/2 = 16.5 。
     * 我们需要 3 个操作实现题目要求，所以返回 3 。
     * 可以证明，无法通过少于 3 个操作使数组和减少至少一半。
     *
     * @param nums nums = [5,19,8,1]
     * @return 3
     */
    public int halveArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(Arrays.stream(nums)
                .asDoubleStream()
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new)));
        long sum = Arrays.stream(nums).asLongStream().sum();
        int i = 0;
        double cur = sum;
        while ((sum / 2.0) < cur) {
            double top = queue.poll();
            cur -= (top / 2.0);
            queue.offer(top / 2.0);
            i++;
        }
        return i;
    }
}
