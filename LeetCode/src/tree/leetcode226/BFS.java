package tree.leetcode226;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/** 反转二叉树
 * @author WanJie
 * @describe
 * @since 2022/10/5 17:06
 */
public class BFS {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 交换node的左右子节点
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
