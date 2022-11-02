package tree.interview0406;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WanJie
 * @describe 暴力遍历
 * @since 2022/10/6 20:43
 */
public class Solution {

    private List<TreeNode> l = new ArrayList<>();

    private TreeNode ans = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (ans != null) {
            return ans;
        }

        inorderSuccessor(root.left, p);
        l.add(root);
        if (l.size() >= 2) {
            if (l.get(l.size() - 2) == p) {
                ans = l.get(l.size() - 1);
            }
        }
        inorderSuccessor(root.right, p);

        return ans;
    }
}
