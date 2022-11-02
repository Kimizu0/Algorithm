package dp.lc740;

/**
 * 删除并获得点数
 *
 * @author WanJie
 * @describe
 * @since 2022/10/13 22:51
 */
public class DP {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] trans = new int[maxVal + 1];

        // 获取每个节点值的价值
        for (int val : nums) {
            trans[val] += val;
        }

        return rob(trans);
    }

    /**
     * 打家劫舍I
     * @param trans 数组
     * @return 偷盗的最大价值
     */
    private int rob(int[] trans) {
        int n = trans.length;
        int prev = trans[0];
        int curr = Math.max(trans[0], trans[1]);

        for (int i = 2; i < n; i++) {
            int next = Math.max(prev + trans[i], curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
