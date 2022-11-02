package dp.lc139_mark;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * 单词拆分
 *
 * @author WanJie
 * @describe https://leetcode.cn/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
 * @since 2022/10/21 20:35
 */
public class DP {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 1) {
            return Objects.equals(s, wordDict.get(0));
        }
        wordDict.sort(Comparator.comparingInt(String::length));
        String target = s.replaceAll(wordDict.get(0), "");
        for (int i = 1; i < wordDict.size(); i++) {
            target = target.replaceAll(wordDict.get(i), "");
            if (target.equals("")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcodeleet";
        String substring = s.substring(0, 0);
        System.out.println(substring);
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        System.out.println(set.contains(substring));
    }
}
