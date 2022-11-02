package dp.lc121;

/**买卖股票的最佳时机
 * @author WanJie
 * @describe 滑动窗口优化
 * @since 2022/10/17 14:37
 */
public class SW {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            ans = Math.max(ans,prices[i] - minPrice);
        }
        return ans;
    }
}
