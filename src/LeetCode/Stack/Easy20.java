package LeetCode.Stack;

import java.util.Stack;

public class Easy20 {

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }

    // Easy 20. Valid Parentheses
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty())
                stack.push(c);
            else if (stack.peek() == '(' && c == ')')
                stack.pop();
            else if (stack.peek() == '[' && c == ']')
                stack.pop();
            else if (stack.peek() == '{' && c == '}')
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }

}
