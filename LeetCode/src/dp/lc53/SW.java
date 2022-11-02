package dp.lc53;

/**
 * 最大子数组和
 *
 * @author WanJie
 * @describe 滑动窗口优化
 * @since 2022/10/15 23:26
 */
public class SW {
    public int maxSubArray(int[] nums) {
        int prev = 0;
        int maxAns = nums[0];
        for (int val : nums) {
            prev = Math.max(prev + val, val);
            maxAns = Math.max(maxAns, prev);
        }
        return maxAns;
    }
}
