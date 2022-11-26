package slidingwindow.lc209;

/**
 * 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
 * O(n, 1)
 *
 * @author WanJie
 * @since 2022-11-21 20:59
 */
public class Solution1 {
    public int minSubArrayLen(int target, int[] nums) {
        // 窗口左右指针
        int start = 0, end = 0;
        int ans = Integer.MAX_VALUE;
        // 每一次滚动的和
        int sum = 0;

        int length = nums.length;
        while (end < length) {
            sum += nums[end];
            while (sum >= target) {
                // 减去左指针位置的值，并更新最小长度，左指针右移，直至 sum < target
                sum -= nums[start];
                ans = Math.min(ans, end - start + 1);
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
