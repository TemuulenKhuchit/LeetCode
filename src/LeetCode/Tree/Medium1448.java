package LeetCode.Tree;

public class Medium1448 {

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

    // Medium 1448. Count Good Nodes in Binary Tree
    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode node, int max) {
        if (node.val >= max) {
            count++;
            max = node.val;
        }
        if (node.left != null) dfs(node.left, max);
        if (node.right != null) dfs(node.right, max);
    }
}
