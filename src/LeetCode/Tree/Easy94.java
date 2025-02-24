package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Easy94 {

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

    // Easy 94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res) {
        if (root != null) {
            traverse(root.left, res);
            res.add(root.val);
            traverse(root.right, res);
        }
    }
}

