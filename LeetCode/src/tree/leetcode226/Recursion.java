package tree.leetcode226;

import tree.TreeNode;

/** 反转二叉树
 * @author WanJie
 * @describe
 * @since 2022/10/3 20:18
 */
public class Recursion {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
