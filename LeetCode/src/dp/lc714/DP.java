package dp.lc714;

/**
 * 买卖股票的最佳时机含手续费
 *
 * @author WanJie
 * @describe
 * @since 2022/10/21 19:56
 */
public class DP {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // dp[i][0] 截止 i 天交易结束后手里没有股票
        // dp[i][1] 截止 i 天交易结束后手里有一支股票
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 昨天就没有股票 | 今天才没有的(把昨天持有的股票在今天卖了)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 昨天就持有股票 | 昨天不持有，今天才买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0] - prices[i]);
        }
        // 截止最后一天，手里持有股票没有意义，故需要不持有股票(全部卖出)的利益最大
        return dp[n-1][0];
    }
}
