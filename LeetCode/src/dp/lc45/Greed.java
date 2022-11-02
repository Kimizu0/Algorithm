package dp.lc45;

/** 跳跃游戏 II
 * @author WanJie
 * @describe 贪心 O(n,1)
 * @since 2022/10/14 10:29
 */
public class Greed {
    public int jump(int[] nums) {
        // 跳的步数
        int steps = 0;
        // 当前能跳的最远距离
        int maxD = 0;
        // 当前能跳的范围边界
        int end = 0;

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            // 当前位置出发最远距离
            maxD = Math.max(maxD, nums[i] + i);
            // 到达边界，刷新为最远距离为新边界
            if (i == end) {
                end = maxD;
                steps++;
            }
        }
        return steps;
    }
}
