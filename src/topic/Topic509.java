package topic;

/**
 * @author: ywx
 * @description 斐波那契数
 * @Date: 2022/07/26
 */

public class Topic509 {
    /**
     * 栈溢出
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 带备忘录的递归解法
     * 「自顶向下」进行「递归」求解
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        int[] emo = new int[n + 1];
        // 进行带备忘录的递归
        return helper(emo, n);
    }

    private int helper(int[] emo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (emo[n] != 0) {
            return emo[n];
        }
        emo[n] = helper(emo, n - 1) + helper(emo, n - 2);
        return emo[n];
    }

    /**
     * dp 数组的迭代（递推）解法
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
