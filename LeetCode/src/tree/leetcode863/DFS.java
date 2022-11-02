package tree.leetcode863;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 二叉树中所有距离为 K 的结点
 *
 * @author WanJie
 * @describe dfs + 哈希
 * https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/solution/er-cha-shu-zhong-suo-you-ju-chi-wei-k-de-qbla/
 * 时间复杂度：O(n)O(n)
 * 空间复杂度：O(n)O(n)
 * @since 2022/10/6 19:21
 */
public class DFS {

    /**
     * 存储每个节点的父节点
     */
    private HashMap<Integer, TreeNode> parents = new HashMap<>();

    /**
     * 距离为 K 的节点值列表
     */
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // dfs 寻找所有节点的父节点
        findParents(root);

        // dfs获取ans,从target开始搜索，from避免重复向下搜索
        dfsAns(target, null, 0, k);

        return ans;
    }


    /**
     * 从 root 开始遍历所有节点的父节点存入hashmap
     *
     * @param root 根节点
     */
    private void findParents(TreeNode root) {
        if (root.left != null) {
            parents.put(root.left.val, root);
            findParents(root.left);
        }

        if (root.right != null) {
            parents.put(root.right.val, root);
            findParents(root.right);
        }
    }

    /**
     * 寻找所有距离 node K个距离的所有节点，放入 ans中
     *
     * @param node  目标节点
     * @param from  目标节点来自于，避免在向上搜索的过程中重复向下搜索
     * @param depth 当前 node 的深度
     * @param k     距离
     */
    private void dfsAns(TreeNode node, TreeNode from, int depth, int k) {
        // null 节点，返回 []
        if (node == null) {
            return;
        }

        // 满足距离K加入ans，停止本次搜索
        if (depth == k) {
            ans.add(node.val);
            return;
        }

        // 根据左右子节点向下搜索，使用 from 避免向上搜索的过程中重复向下搜索
        if (node.left != from) {
            dfsAns(node.left, node, depth + 1, k);
        }

        if (node.right != from) {
            dfsAns(node.right, node, depth + 1, k);
        }

        // 通过父节点向上搜索
        if (parents.get(node.val) != from) {
            dfsAns(parents.get(node.val), node, depth + 1, k);
        }
    }

}
