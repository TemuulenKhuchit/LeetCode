package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Easy145 {

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

    // Easy 145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res) {
        if (root != null) {
            traverse(root.left, res);
            traverse(root.right, res);
            res.add(root.val);
        }
    }
}
