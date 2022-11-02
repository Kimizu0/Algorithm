package tree.leetcode104;

import tree.TreeNode;

/**
 * @author WanJie
 * @describe
 * @since 2022/10/7 13:51
 */
public class DFS {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

}
