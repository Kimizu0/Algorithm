package dp.lc918;

/**环形子数组的最大和
 * @author WanJie
 * @describe 动态规划分情况讨论
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/solution/java-dp-kan-bu-dong-wei-shi-yao-sum-min-x7q53/
 * @since 2022/10/16 20:31
 */
public class DP {
    public int maxSubarraySumCircular(int[] nums) {
        // dp[i] 保存以 i 结尾的最大子段和
        int[] dp = new int[nums.length];

        // 初始化dp
        dp[0] = nums[0];

        // 最大字段和
        int max = dp[0];

        // 数组和
        int sum = dp[0];

        // 寻找最大子段和[0,n-1]与数组和
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        // 寻找最小子段和[1,n-2]
        int min = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.min(dp[i - 1] + nums[i], nums[i]);
            min = Math.min(min, dp[i]);
        }

        // 两种情况:
        // 1.最大子段和不在环内，则最大子段和即为max
        // 2.最大字段和在环内，最大字段和为 数组和-最小字段和 即，sum-min
        // 最终答案为两种情况取较大值
        return Math.max(sum - min, max);
    }
}
