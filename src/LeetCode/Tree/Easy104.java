package LeetCode.Tree;

public class Easy104 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Easy 226. Invert Binary Tree
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = 1, right = 1;
        left += maxDepth(root.left);
        right += maxDepth(root.right);
        return Math.max(left, right);
    }
}
