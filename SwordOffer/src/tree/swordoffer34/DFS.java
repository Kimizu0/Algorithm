package tree.swordoffer34;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**二叉树中和为某一值的路径
 * @author WanJie
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-68dg/
 * @describe dfs
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @since 2022/10/3 12:12
 */
public class DFS {

    private Deque<Integer> path = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;

    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        path.offer(root.val);

        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, target);
        dfs(root.right, target);

        // 回退节点时删除节点
        path.pollLast();
    }


}
