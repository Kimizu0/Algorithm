package slidingwindow.lc3;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 *
 * @author WanJie
 * @since 2022-11-20 21:50
 */
public class First {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int ans = 0;
        int l = 0;
        int r;
        HashSet<Character> set = new HashSet<>();

        for (; l < s.length(); l++) {
            set.add(s.charAt(l));
            r = l + 1;
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            ans = Math.max(ans, r - l);
            set.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        int length = new First().lengthOfLongestSubstring("abcbacbb");
        System.out.println("length = " + length);
    }
}