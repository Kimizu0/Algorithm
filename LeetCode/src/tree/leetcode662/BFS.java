package tree.leetcode662;

/** 二叉树最大宽度
 * @author WanJie
 * @describe https://leetcode.cn/problems/maximum-width-of-binary-tree/solution/er-cha-shu-zui-da-kuan-du-by-leetcode-so-9zp3/
 * 时间复杂度：O(n)O(n)
 * 空间复杂度：O(n)O(n)
 * @since 2022/10/6 14:16
 */
public class BFS {

    //public int widthOfBinaryTree(TreeNode root) {
    //    int res = 1;
    //
    //    // Pair<TreeNode, INDEX>
    //    ArrayDeque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
    //    queue.offer(new Pair<>(root, 1));
    //    while (!queue.isEmpty()) {
    //        ArrayDeque<Pair<TreeNode, Integer>> tmp = new ArrayDeque<>();
    //        for (Pair<TreeNode, Integer> pair : queue) {
    //            TreeNode node = pair.getKey();
    //            Integer index = pair.getValue();
    //            if (node.left != null) {
    //                tmp.offer(new Pair<>(node.left, 2 * index));
    //            }
    //            if (node.right != null) {
    //                tmp.offer(new Pair<>(node.right, 2 * index + 1));
    //            }
    //        }
    //        res = Math.max(res, queue.peekLast().getValue() - queue.peekFirst().getValue() + 1);
    //        queue = tmp;
    //    }
    //    return res;
    //}

}
