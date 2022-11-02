package dp.lc152;

/**
 * 乘积最大子数组
 *
 * @author WanJie
 * @describe
 * @since 2022/10/16 21:35
 */
public class DP {
    public int maxProduct(int[] nums) {
        // 当前最大乘积
        int imax = 1;
        // 当前最小乘积
        int imin = 1;
        // 最大乘积
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < 0) {
                int t;
                t = imin;
                imin = imax;
                imax = t;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(max, imax);
        }
        return max;
    }
}
