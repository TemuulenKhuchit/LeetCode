package Weekly.Contest419;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int val) {
        this.val = val;
    }
}

public class Question2 {

    private static class SubtreeInfo {
        boolean isPerfect;
        int size;
        int height;

        SubtreeInfo(boolean isPerfect, int size, int height) {
            this.isPerfect = isPerfect;
            this.size = size;
            this.height = height;
        }
    }

    public static int findKthLargestPerfectSubtree(TreeNode1 root, int k) {
        List<Integer> perfectSubtreeSizes = new ArrayList<>();
        findPerfectSubtrees(root, perfectSubtreeSizes);

        // Sort the sizes in descending order
        Collections.sort(perfectSubtreeSizes, Collections.reverseOrder());

        // Return the k-th largest size or -1 if there are not enough subtrees
        return perfectSubtreeSizes.size() >= k ? perfectSubtreeSizes.get(k - 1) : -1;
    }

    private static SubtreeInfo findPerfectSubtrees(TreeNode1 node, List<Integer> perfectSubtreeSizes) {
        if (node == null) {
            return new SubtreeInfo(true, 0, 0);
        }

        SubtreeInfo leftInfo = findPerfectSubtrees(node.left, perfectSubtreeSizes);
        SubtreeInfo rightInfo = findPerfectSubtrees(node.right, perfectSubtreeSizes);

        boolean isPerfect = leftInfo.isPerfect && rightInfo.isPerfect && (leftInfo.height == rightInfo.height);

        if (isPerfect) {
            int currentSize = leftInfo.size + rightInfo.size + 1;
            int currentHeight = leftInfo.height + 1;
            perfectSubtreeSizes.add(currentSize);
            return new SubtreeInfo(true, currentSize, currentHeight);
        } else {
            return new SubtreeInfo(false, 0, 0);
        }
    }

    public static void main(String[] args) {

        // Example 1:
        TreeNode1 root1 = new TreeNode1(5);
        root1.left = new TreeNode1(3);
        root1.right = new TreeNode1(6);
        root1.left.left = new TreeNode1(5);
        root1.left.right = new TreeNode1(2);
        root1.right.left = new TreeNode1(5);
        root1.right.right = new TreeNode1(7);
        root1.left.left.left = new TreeNode1(1);
        root1.left.left.right = new TreeNode1(8);
        root1.right.left.left = new TreeNode1(6);
        root1.right.left.right = new TreeNode1(8);
        System.out.println(findKthLargestPerfectSubtree(root1, 2));  // Output: 3

        // Example 2:
        TreeNode1 root2 = new TreeNode1(1);
        root2.left = new TreeNode1(2);
        root2.right = new TreeNode1(3);
        root2.left.left = new TreeNode1(4);
        root2.left.right = new TreeNode1(5);
        root2.right.left = new TreeNode1(6);
        root2.right.right = new TreeNode1(7);
        System.out.println(findKthLargestPerfectSubtree(root2, 1));  // Output: 7

        // Example 3:
        TreeNode1 root3 = new TreeNode1(1);
        root3.left = new TreeNode1(2);
        root3.left.right = new TreeNode1(4);
        System.out.println(findKthLargestPerfectSubtree(root3, 3));  // Output: -1
    }

}