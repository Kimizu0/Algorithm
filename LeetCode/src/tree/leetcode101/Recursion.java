package tree.leetcode101;

import tree.TreeNode;

/** 对称二叉树
 * @author WanJie
 * @describe 递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @since 2022/10/3 18:28
 */
public class Recursion {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 判断两棵树是否对称，即在两棵子树都不为空的情况下，
     * p.val == q.val && p.left.val == q.right.val && p.right.val == q.left.val
     * 当然这里使用递归判断更下层的情况
     * @param p 左子树
     * @param q 右字数
     * @return 是否对称
     */
    private boolean check(TreeNode p, TreeNode q) {
        // 同时为null，必然对称
        if (p == null && q == null) {
            return true;
        }

        // 有一个为null，必然不对称
        if (p == null || q == null) {
            return false;
        }

        // 递归判断
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


}
