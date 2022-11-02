package dp.lc1567;

/**
 * @author WanJie
 * @describe 滑动数组，优化O(n,1)
 * @since 2022/10/17 9:34
 */
public class SW {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int maxLength = positive;

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                int newPositive = negative > 0 ? negative + 1 : 0;
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            } else {
                positive = 0;
                negative = 0;
            }
            maxLength = Math.max(maxLength, positive);
        }
        return maxLength;
    }
}
