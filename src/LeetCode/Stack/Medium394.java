package LeetCode.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Medium394 {

    // Medium 394. Decode String
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
                continue;
            }

            List<Character> decodedString = new ArrayList<>();
            while (stack.peek() != '[')
                decodedString.add(stack.pop());
            stack.pop();

            int base = 1;
            int k = 0;
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                k = k + (stack.pop() - '0') * base;
                base *= 10;
            }

            while (k > 0) {
                for (int j = decodedString.size() - 1; j >= 0; j--)
                    stack.push(decodedString.get(j));
                k--;
            }
        }

        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--)
            result[i] = stack.pop();

        return new String(result);
    }
}
