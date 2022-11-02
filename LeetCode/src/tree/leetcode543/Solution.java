package tree.leetcode543;

import tree.TreeNode;

/**
 * 二叉树的直径
 *
 * @author WanJie
 * @describe dfs
 * @since 2022/10/5 17:24
 */
public class Solution {

    /**
     * 二叉树的直径 = 二叉树中最长的最短路径
     * 任意节点 node 的最短路径 = 左子树的深度 + 右子树的深度
     * 某个节点的深度为 max(左子树深度，右子树深度) + 1 ，加1是因为父节点深度 = 子树最大深度 —— 1；
     * 最长最短路径 = 左子树的深度+右子树的深度，即为答案
     */

    /**
     * 最大深度
     */
    private int maxd = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }

    /**
     * 求 root 节点的深度
     *
     * @param root
     */
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftChildDepth;
        int rightChildDepth;

        leftChildDepth = depth(root.left);
        rightChildDepth = depth(root.right);
        // dfs，遍历过程中，最长路径是不断更新的。
        maxd = Math.max(leftChildDepth + rightChildDepth, maxd);
        return Math.max(leftChildDepth, rightChildDepth) + 1;
    }
}
