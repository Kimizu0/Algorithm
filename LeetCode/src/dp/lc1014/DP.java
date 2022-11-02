package dp.lc1014;

/**最佳观光组合
 * @author WanJie
 * @describe
 * @since 2022/10/17 13:53
 */
public class DP {
    public int maxScoreSightseeingPair(int[] A) {
        // values[i] + values[j] + i - j 等价于 values[i] + i +values[j]-j
        // 求 values[i] + i +values[j]-j 的最大值，values[j]-j 不变，使得values[i]+i最大化即可
        int ans = 0;
        int mx = A[0] + 0;

        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, mx + A[i] - i);
            mx = Math.max(mx, A[i] + i);
        }
        return ans;
    }
}
