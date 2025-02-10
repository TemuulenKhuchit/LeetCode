package LeetCode.Uncategorized;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Easy3174 {

    // Easy 3174. Clear Digits
    public String clearDigits(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                dq.pollLast();
            else
                dq.offerLast(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty())
            sb.append(dq.pollFirst());
        return sb.toString();
    }
}
