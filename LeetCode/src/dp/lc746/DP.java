package dp.lc746;

/**
 * 使用最小花费爬楼梯
 *
 * @author WanJie
 * @describe 动态规划
 * @since 2022/10/12 21:46
 */
public class DP {
    public int minCostClimbingStairs(int[] cost) {
        // 题目意思有点不清晰，最后一阶并不是楼顶，需要到达楼顶之后才算到达楼顶。
        int n = cost.length;
        // n + 1，前n个是爬到n阶楼梯的最小花费，最后1个是到达楼顶的花费。
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        if (dp[n] != 0) {
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
