package tree.leetcode104;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/** 二叉树的最大深度
 * @author WanJie
 * @describe bfs
 * 时间复杂度：O(n)
 * 空间复杂度：O(n) worst
 * @since 2022/10/7 13:37
 */
public class BFS {

    private int ans = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return ans;
        }

        return bfs(root);
    }

    private int bfs(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
