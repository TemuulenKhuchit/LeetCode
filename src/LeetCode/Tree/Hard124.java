package LeetCode.Tree;

public class Hard124 {

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

    // Hard 124. Binary Tree Maximum Path Sum
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        postOrderDfs(root);
        return maxSum;
    }

    private int postOrderDfs(TreeNode node) {
        if (node == null)
            return 0;

        int maxLeft = Math.max(postOrderDfs(node.left), 0);
        int maxRight = Math.max(postOrderDfs(node.right), 0);

        maxSum = Math.max(maxSum, node.val + maxLeft + maxRight);

        return Math.max(node.val + maxLeft, node.val + maxRight);
    }
}
