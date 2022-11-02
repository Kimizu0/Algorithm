package dp.lc198;

/** 打家劫舍
 * @author WanJie
 * @describe 滑动窗口 O(n) O(1)
 * @since 2022/10/13 21:47
 */
public class SW {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev = nums[0];
        if (n == 1) {
            return prev;
        }

        int curr = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int next = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
