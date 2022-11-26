package slidingwindow.lc904;

import java.util.HashMap;

/**
 * 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/solution/shui-guo-cheng-lan-by-leetcode-solution-1uyu/
 * O(n,1)
 *
 * @author WanJie
 * @since 2022-11-22 14:05
 */
public class Solution1 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int ans = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>(3);
        for (int right = 0; right < n; ++right) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
