package dp.lc309;

/**最佳买卖股票时机含冷冻期
 * @author WanJie
 * @describe 动他规划
 * @since 2022/10/20 23:54
 */
public class DP {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;

        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][2] - prices[i]);
            f[i][1] = f[i-1][0]+prices[i];
            f[i][2] = Math.max(f[i-1][1], f[i-1][2]);
        }
        return Math.max(f[n-1][1],f[n-2][2]);
    }
}
