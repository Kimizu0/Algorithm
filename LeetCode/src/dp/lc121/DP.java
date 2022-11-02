package dp.lc121;

/**
 * 买卖股票的最佳时机
 *
 * @author WanJie
 * @describe 动态规划
 * @since 2022/10/17 14:27
 */
public class DP {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i] 表示截止第i天的最低价格
        int[] dp = new int[n];
        // 初始化dp
        dp[0] = prices[0];

        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            ans = Math.max(ans, prices[i] - dp[i]);
        }
        return ans;
    }
}
