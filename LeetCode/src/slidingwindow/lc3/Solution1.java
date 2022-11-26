package slidingwindow.lc3;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 * O(n, n)
 *
 * @author WanJie
 * @since 2022-11-21 12:19
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int ans = 0;
        // 左指针
        int left = 0;
        // 记录字符出现的位置与重复字符判断
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        // 右指针
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                // 出现重复字符，左指针应指向下一个字符，并记录最大长度
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(s.charAt(right), right);
        }
        return ans;
    }
}