package dp.lc264;

/**丑数 II
 * @author WanJie
 * @describe
 * @since 2022/10/23 22:03
 */
public class DP {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));

            if (dp[i] == num2) {
                p2++;
            }

            if (dp[i] == num3) {
                p3++;
            }

            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
