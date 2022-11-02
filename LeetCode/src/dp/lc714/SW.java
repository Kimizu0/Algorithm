package dp.lc714;

/**
 * 买卖股票的最佳时机含手续费
 *
 * @author WanJie
 * @describe
 * @since 2022/10/21 20:20
 */
public class SW {
    public int maxProfit(int[] prices, int fee) {        int n = prices.length;
        // f0 截止 i 天交易结束后手里没有股票
        // f1 截止 i 天交易结束后手里有一支股票
        int f0 = 0;
        int f1 = -prices[0];

        for (int i = 1; i < n; i++) {
            // 昨天就没有股票 | 今天才没有的(把昨天持有的股票在今天卖了)
            f0 = Math.max(f0, f1 + prices[i] - fee);
            // 昨天就持有股票 | 昨天不持有，今天才买入
            f1 = Math.max(f1, f0 - prices[i]);
        }
        // 截止最后一天，手里持有股票没有意义，故需要不持有股票(全部卖出)的利益最大
        return f0;
    }
}
