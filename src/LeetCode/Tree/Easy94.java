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

    private List<Integer> res = new ArrayList<>();

    // Easy 94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            res.add(root.val);
            dfs(root.right);
        }
    }
}

