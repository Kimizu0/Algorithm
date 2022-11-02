package dp.lc413;

/**
 * 等差数列划分
 *
 * @author WanJie
 * @describe
 * @since 2022/10/22 20:58
 */
public class DP {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        // dp[i]：截至第i个元素有多少个等差子数组
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}
