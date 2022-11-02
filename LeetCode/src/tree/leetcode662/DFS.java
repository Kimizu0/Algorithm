package tree.leetcode662;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/** 二叉树最大宽度
 * @author WanJie
 * @describe 不会
 * @since 2022/10/6 15:31
 */
public class DFS {

    Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        levelMin.putIfAbsent(depth, index);
        return Math.max(index - levelMin.get(depth) + 1,
                Math.max(dfs(node.left, depth + 1, index * 2),
                        dfs(node.right, depth + 1, index * 2 + 1)));
    }
}
