package tree.leetcode114;

import tree.TreeNode;

/**
 * @author WanJie
 * @describe 寻找前驱节点
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
 * @since 2022/10/7 14:42
 */
public class Prev {

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            TreeNode prev = curr.left;
            TreeNode next = curr.left;
            if (curr.left != null) {
                // 寻找最右节点
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
