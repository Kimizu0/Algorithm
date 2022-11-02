package tree.leetcode226;

import tree.TreeNode;

/**
 * @author WanJie
 * @describe
 * @since 2022/10/5 17:16
 */
public class DFS {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
