package recursion.leetcode231;

import java.util.HashMap;

/** 2 的幂
 * @author WanJie
 * @describe https://leetcode.cn/problems/power-of-two/solution/2de-mi-by-leetcode-solution-rny3/
 * @since 2022/10/9 20:25
 */
public class Solution {
    private HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean isPowerOfTwo(int n) {
        int count = 0;
        int tmp = Math.abs(n);

        while (tmp != 0) {
            if ((tmp & 1) == 1) {
                count++;
            }
            tmp >>>= 1;
        }

        if (n > 0) {
            return count == 1;
        } else {
            return ++count == 2;
        }
    }

    public static void main(String[] args) {
        new Solution().isPowerOfTwo(-12);
    }
}
