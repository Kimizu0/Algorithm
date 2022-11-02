package dp.lc413;

/**
 * 等差数列划分
 *
 * @author WanJie
 * @describe
 * @since 2022/10/22 21:06
 */
public class SW {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        // dp[i]：截至第i个元素有多少个等差子数组
        //int[] dp = new int[n];
        int prev = 0, curr = 0;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr = ++prev;
                ans += curr;
            } else {
                prev = 0;
            }
        }
        return ans;
    }
}
