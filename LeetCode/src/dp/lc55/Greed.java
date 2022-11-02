package dp.lc55;

/**
 * 跳跃游戏
 *
 * @author WanJie
 * @describe 贪心 O(n,n)
 * @since 2022/10/14 10:15
 */
public class Greed {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxD = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxD) {
                maxD = Math.max(maxD, i + nums[i]);
                if (maxD >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
