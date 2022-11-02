package dp.lc213;

import java.util.Arrays;

/**
 * 打家劫舍II
 *
 * @author WanJie
 * @describe 打家劫舍I分情况讨论即可 O(n) O(n), 可以不维护数组，直接取原数组值即可，优化为O(1),这里偷个懒。
 * @since 2022/10/13 21:57
 */
public class DP {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // 偷第一间房屋，不偷最后一间房屋,nums[0,n-1)
        int[] robFirst = Arrays.copyOfRange(nums, 0, n - 1);
        // 偷最后一间房屋，不偷第一间房屋,nums[1,n)
        int[] robLast = Arrays.copyOfRange(nums, 1, n);
        return Math.max(handle(robFirst), handle(robLast));
    }

    private int handle(int[] nums) {
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

