package tree.leetcode101;


import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author WanJie
 * @describe 迭代
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @since 2022/10/3 19:51
 */
public class Iterator {


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {

        Deque<TreeNode> q = new LinkedList<>();

        q.offer(u);
        q.offer(v);

        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();

            if (u == null && v == null) {
                continue;
            }

            if ((u == null || v == null) || u.val != v.val) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }

        return true;
    }
}
