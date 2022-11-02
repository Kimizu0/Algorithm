package tree.swordoffer55;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * @author WanJie
 * @describe 广度优先
 * 时间复杂度：O(n)
 * 空间复杂度：O(sizeof(queue), worst is O(n)
 * @since 2022/10/3 11:31
 */
public class BFS {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                size--;
            }
            res++;
        }
        return res;
    }

}
