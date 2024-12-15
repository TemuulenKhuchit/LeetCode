package Problems.Uncategorized;

import java.util.ArrayDeque;
import java.util.Deque;

public class Easy20 {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    // Easy 20. Valid Parentheses
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty())
                stack.add(c);
            else
                if ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}') || (stack.peek() == '[' && c == ']'))
                    stack.pop();
                else stack.push(c);
        }

        return stack.isEmpty();
    }
}
