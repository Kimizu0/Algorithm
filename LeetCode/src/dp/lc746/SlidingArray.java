package dp.lc746;

/**
 * 使用最小花费爬楼梯
 *
 * @author WanJie
 * @describe 运用滑动窗口将动态规划的空间复杂度优化成O(1)
 * @since 2022/10/12 22:24
 */
public class SlidingArray {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = 0;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(prev + cost[i - 2], curr + cost[i - 1]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
