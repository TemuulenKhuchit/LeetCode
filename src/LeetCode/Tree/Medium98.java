package LeetCode.Tree;

public class Medium98 {

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

    // Medium 98. Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer low, Integer high) {
        if (node == null)
            return true;

        if (
                (low != null && node.val <= low) ||
                        (high != null && node.val >= high)
        )
            return false;

        return (
                dfs(node.right, node.val, high) &&
                        dfs(node.left, low, node.val)
        );
    }

}
