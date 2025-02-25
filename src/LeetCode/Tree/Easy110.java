package LeetCode.Tree;

public class Easy110 {

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

    // Easy 110. Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return (
                Math.abs(treeHeight(root.left) - treeHeight(root.right)) < 2 &&
                isBalanced(root.left) &&
                isBalanced(root.right)
        );
    }

    private int treeHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}
