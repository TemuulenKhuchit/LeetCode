package LeetCode.Stack;

import java.util.Stack;

public class Medium71 {

    // Medium 71. Simplify Path
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty())
                continue;
            else if (directory.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.add(directory);
        }

        StringBuilder res = new StringBuilder();
        for (String dir : stack)
            res.append("/").append(dir);

        return res.length() > 0 ? res.toString() : "/";
    }
}
