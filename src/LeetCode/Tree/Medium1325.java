package LeetCode.Tree;

public class Medium1325 {

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

    // Medium 1325. Delete Leaves With a Given Value
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return postOrderDfs(root, target);
    }

    private TreeNode postOrderDfs(TreeNode node, int target) {
        if (node.left != null) node.left = postOrderDfs(node.left, target);
        if (node.right != null) node.right = postOrderDfs(node.right, target);
        if (node.left == null && node.right == null && node.val == target)
            return null;
        return node;
    }
}
