package tree.leetcode114;

import tree.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树展开为链表
 *
 * @author WanJie
 * @describe 前序遍历
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
 * @since 2022/10/7 14:04
 */
public class Preorder {

    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorder(TreeNode root, ArrayList<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

}
