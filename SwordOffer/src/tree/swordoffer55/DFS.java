package tree.swordoffer55;


import tree.TreeNode;

/**
 * 二叉树的深度
 *
 * @author WanJie
 * @describe dfs
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/solution/er-cha-shu-de-shen-du-by-leetcode-soluti-dk8c/
 * 时间复杂度：O(n)
 * 空间复杂度：O(height)
 * @since 2022/10/3 10:28
 */
public class DFS {

    /**
     * 递归函数定义：maxDepth(node) 表示以node为根节点的最大深度
     * 递归出口: node == null, 则 depth = 0
     * 递归方程: maxDepth(node) = Math.max(maxDepth(node.left) , maxDepth(node.right)) + 1;
     * @param root 根节点
     * @return 表示以root为根节点的最大深度
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // root的深度
        int depth = 0;
        // 左子树深度
        int leftDepth = 0;
        // 右子树深度
        int rightDepth = 0;

        leftDepth += maxDepth(root.left);

        rightDepth += maxDepth(root.right);

        depth += Math.max(leftDepth, rightDepth) + 1;

        return depth;
    }

}
