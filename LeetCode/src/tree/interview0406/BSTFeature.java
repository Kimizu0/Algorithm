package tree.interview0406;

import tree.TreeNode;

/**
 * 面试题 04.06. 后继者
 *
 * @author WanJie
 * @describe 运用二叉搜索时特性
 * https://leetcode.cn/problems/successor-lcci/solution/hou-ji-zhe-by-leetcode-solution-6hgc/
 * @since 2022/10/7 13:21
 */
public class BSTFeature {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 节点 p 有右节点
        TreeNode successor = null;

        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }

        // 右子树为空,从根节点开始寻找p的父节点
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }

}
