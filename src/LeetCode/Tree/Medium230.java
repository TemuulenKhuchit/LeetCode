package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Medium230 {

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

    // Medium 230. Kth Smallest Element in a BST
    // Approach 1: Recursive Inorder Traversal
    List<Integer> list = new ArrayList<>();

    public int kthSmallestRecursive(TreeNode root, int k) {
        inOrderDfs(root);
        return list.get(k - 1);
    }

    private void inOrderDfs(TreeNode node) {
        if (node.left != null) inOrderDfs(node.left);
        list.add(node.val);
        if (node.right != null) inOrderDfs(node.right);
    }

    // Approach 2: Iterative Inorder Traversal
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }
}
