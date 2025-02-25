package LeetCode.Tree;

public class Medium701 {

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

    // Medium 701. Insert into a Binary Search Tree
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode curr = root;
        while (root != null) {
            if (curr.val > val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return root;
                }
                else curr = curr.left;
            }
            else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return root;
                }
                else curr = curr.right;
            }
        }
        return root;
    }
}
