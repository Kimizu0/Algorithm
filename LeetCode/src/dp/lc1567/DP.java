package dp.lc1567;

/**
 * 乘积为正数的最长子数组长度
 *
 * @author WanJie
 * @describe O(n,n)
 * @since 2022/10/16 22:14
 */
public class DP {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        // 定义dp
        int[] positive = new int[n];
        int[] negative = new int[n];

        // 初始化dp
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        } else {
            positive[0] = negative[0] = 0;
        }

        // 乘积为正最大子数组长度
        int posMaxLength = positive[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = negative[i] = 0;
            }
            posMaxLength = Math.max(posMaxLength, positive[i]);
        }
        return posMaxLength;
    }
}
