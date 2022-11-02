package dp.lc509;

/** 斐波那契数列
 * @author WanJie
 * @describe
 * @since 2022/10/11 8:55
 */
public class DP {
    public int fib(int n) {
        int[] dp = new int[30];
        dp[0] = 0;
        dp[1] = 1;
        if (dp[n] != 0) {
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
