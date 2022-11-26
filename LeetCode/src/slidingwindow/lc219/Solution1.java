package slidingwindow.lc219;

import java.util.HashSet;

/**
 * 存在重复元素 II
 * https://leetcode.cn/problems/contains-duplicate-ii/solution/gong-shui-san-xie-hua-dong-chuang-kou-yu-q02i/
 * 官解：滑动窗口 + 哈希表
 *
 * @author WanJie
 * @since 2022-11-23 21:32
 */
public class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 滑动窗口 + 哈希表 O(n), O(k) 至多为 k + 1(每个窗口的容量)
        // 整理题意：是否存在长度不超过的 k + 1k+1 窗口，窗口内有相同元素。
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            if (i > k) {
                // 不在第一个窗口，删除第 i - k - 1 个元素(不在同一个窗口)
                set.remove(nums[i - k - 1]);
            }
            // 同一个窗口包含同重复元素
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
