package dp.lc198;

/** 打家劫舍
 * @author WanJie
 * @describe 动态规划 O(n) O(n)
 * @since 2022/10/13 21:28
 */
public class DP {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if (n == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        if (dp[n - 1] != 0) {
            return dp[n - 1];
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n-1];
    }
}
