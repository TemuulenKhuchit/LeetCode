package LeetCode.Tree;

import java.util.ArrayList;
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
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrderDfs(root);
        return list.get(k - 1);
    }

    private void inOrderDfs(TreeNode node) {
        if (node.left != null) inOrderDfs(node.left);
        list.add(node.val);
        if (node.right != null) inOrderDfs(node.right);
    }
}
