package LeetCode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hard297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    // Hard 297. Serialize and Deserialize Binary Tree
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return helperSerialize(root, "");
    }

    private String helperSerialize(TreeNode node, String str) {
        if (node == null)
            return str += "null,";
        else {
            str += String.valueOf(node.val) + ",";
            str = helperSerialize(node.left, str);
            str = helperSerialize(node.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        List<String> dataList = new ArrayList<>(Arrays.asList(dataArr));
        return helperDeserialize(dataList);
    }

    private TreeNode helperDeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        node.left = helperDeserialize(list);
        node.right = helperDeserialize(list);

        return node;
    }
}
