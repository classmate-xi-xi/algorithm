package topic;

import java.util.Arrays;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/29
 */

public class Topic322 {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -1) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int c : coins) {
            int subRes = dp(coins, amount - c);
            if (subRes == -1) {
                continue;
            }
            result = Math.min(result, subRes + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (result == Integer.MAX_VALUE) ? -1 : result;
        return memo[amount];
    }

    public static void main(String[] args) {
       int s =  new Topic322().coinChange(new int[]{1,2,5}, 100);
        System.out.println(s);
    }
}
