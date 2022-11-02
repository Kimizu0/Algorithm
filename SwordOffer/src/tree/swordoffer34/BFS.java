package tree.swordoffer34;

import tree.TreeNode;

import java.util.*;

/**
 * @author WanJie
 * @describe 广度优先
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-68dg/
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @since 2022/10/3 16:07
 */
public class BFS {

    private List<List<Integer>> res = new LinkedList<>();
    private Deque<Integer> nodeSum = new LinkedList<>();
    // HashMap<child, parent>
    private HashMap<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        bfs(root, target);
        return res;

    }

    private void bfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        Deque<Integer> nodeSum = new LinkedList<>();
        Deque<TreeNode> nodeQueue = new LinkedList<>();

        nodeSum.offer(0);
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int rec = nodeSum.poll() + node.val;

            if (node.left == null && node.right == null && rec == target) {
                getPath(node);
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    nodeSum.offer(rec);
                    nodeQueue.offer(node.left);
                }

                if (node.right != null) {
                    map.put(node.right, node);
                    nodeSum.offer(rec);
                    nodeQueue.offer(node.right);
                }
            }
        }
    }

    private void getPath(TreeNode node) {
        LinkedList<Integer> tmp = new LinkedList<>();
        while (node != null) {
            tmp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(tmp);
        res.add(tmp);
    }


}
