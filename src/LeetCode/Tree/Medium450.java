package LeetCode.Tree;

public class Medium450 {

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

    // Medium 450. Delete Node in a BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // Find the min from the right subtree
            TreeNode curr = root.right;
            while (curr.left != null)
                curr = curr.left;
            root.val = curr.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
}
