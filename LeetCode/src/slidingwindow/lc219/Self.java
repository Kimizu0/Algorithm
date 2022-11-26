package slidingwindow.lc219;

import java.util.HashMap;

/**
 * 存在重复元素 II
 * O(n, n)
 *
 * @author WanJie
 * @since 2022-11-23 21:31
 */
public class Self {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (!map.containsKey(nums[i])
                    || Math.abs(map.get(nums[i]) - i) > k
            ) {
                map.put(nums[i], i);
                continue;
            }

            return true;
        }

        return false;
    }
}
