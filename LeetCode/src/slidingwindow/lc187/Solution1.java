package slidingwindow.lc187;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 重复的DNA序列
 * O(n*C, n)
 * https://leetcode.cn/problems/repeated-dna-sequences/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-30pg/
 *
 * @author WanJie
 * @since 2022-11-26 12:48
 */
public class Solution1 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new LinkedList<>();
        int n = s.length();

        for (int i = 0; i + 10 <= n; i++) {
            String cur = s.substring(i, i + 10);
            int cnt = map.getOrDefault(cur, 0);

            // 重复 DNA 子序列
            if (cnt == 1) {
                ans.add(cur);
            }
            map.put(cur, ++cnt);
        }
        return ans;
    }
}
