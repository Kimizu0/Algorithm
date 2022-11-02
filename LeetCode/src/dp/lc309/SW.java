package dp.lc309;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * @author WanJie
 * @describe 滑动窗口
 * @since 2022/10/21 0:06
 */
public class SW {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;

        for (int i = 1; i < n; i++) {
            int newF0 = Math.max(f0, f2 - prices[i]);
            int newF1 = f0 + prices[i];
            int newF2 = Math.max(f1, f2);

            f0 = newF0;
            f1 = newF1;
            f2 = newF2;
        }

        return Math.max(f1, f2);
    }
}
