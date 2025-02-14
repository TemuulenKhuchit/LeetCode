package LeetCode.Stack;

import java.util.Stack;

public class Medium150 {

    // Medium 150. Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int x = stack.pop();
            int y = stack.pop();
            int ans = switch (token) {
                case "+" -> y + x;
                case "-" -> y - x;
                case "*" -> y * x;
                case "/" -> y / x;
                default -> 0;
            };
            stack.push(ans);
        }
        return stack.pop();
    }
}
