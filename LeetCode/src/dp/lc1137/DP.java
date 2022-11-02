package dp.lc1137;

/**
 * 第 N 个泰波那契数
 *
 * @author WanJie
 * @describe
 * @since 2022/10/11 9:14
 */
public class DP {
    public int tribonacci(int n) {
        int[] dp = new int[38];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        if (n < 3) {
            return dp[n];
        }

        for (int i = 3; i < 38; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
