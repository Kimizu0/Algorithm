package slidingwindow.lc424;

/**
 * 替换后的最长重复字符
 * https://leetcode.cn/problems/longest-repeating-character-replacement/solution/ti-huan-hou-de-zui-chang-zhong-fu-zi-fu-eaacp/
 * O(n, a)
 *
 * @author WanJie
 * @since 2022-11-27 21:29
 */
class Solution1 {
    // O(N), O(A) A: 这里 AA 是输入字符串 tree.com.S 出现的字符 ASCII 值的范围
    public int characterReplacement(String s, int k) {
        char[] charArray = s.toCharArray();
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int n = s.length();
        int res = 0;
        while (right < n) {
            freq[charArray[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;

            if (right - left > maxCount + k) {
                // k不够用
                // maxCount记录了所有窗口出现字符最多的次数
                // maxCount + k 记录了最长重复子串
                // right - left > maxCount + k 表示重复字符+k已经无法填满当前窗口，需要left向右移，right继续右移继续探寻
                // 同时维护好freq即可，maxCount 不能变小，一旦maxCount变小，maxCount+k就会变小，则代表寻找到的最长重复子串变小，没有意义。
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
