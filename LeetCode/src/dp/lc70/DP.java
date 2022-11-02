package dp.lc70;

/**
 * 爬楼梯
 *
 * @author WanJie
 * @describe
 * @since 2022/10/12 21:39
 */
public class DP {
    public int climbStairs(int n) {
        // 1<= n <=45
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;

        if (dp[n] != 0) {
            return dp[n];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
