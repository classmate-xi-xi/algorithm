package topic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: ywx
 * @description 商品折扣后的最终价格
 * @Date: 2022/09/01
 */

public class Topic1475 {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int discount = 0;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            result[i] = prices[i] - discount;
        }
        return result;
    }

    /**
     * 单调栈解法
     */
    public int[] finalPrices1(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && prices[stack.peekLast()] >= prices[i]) {
                int idx = stack.pollLast();
                result[idx] = prices[idx] - prices[i];
            }
            stack.addLast(i);
            result[i] = prices[i];
        }
        return result;
    }
}
