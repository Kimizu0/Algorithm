package tree;

/**
 * @author WanJie
 * @describe
 * @since 2022/10/3 10:30
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
