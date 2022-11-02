package dp.lc122;

/**买卖股票的最佳时机 II
 * @author WanJie
 * @describe 贪心
 * O(n, 1)
 * @since 2022/10/19 22:52
 */
public class DP {
    public int maxProfit(int[] prices) {
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                // 有利可图就卖
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}
