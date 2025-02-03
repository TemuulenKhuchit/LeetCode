package LeetCode.Stack;

import java.util.Stack;

public class Easy682 {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    // Easy 682. Baseball Game
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            if (op.equals("C"))
                stack.pop();
            else if (op.equals("D"))
                stack.push(stack.peek() * 2);
            else if (op.equals("+")) {
                int top = stack.pop();
                int newVal = stack.peek() + top;
                stack.push(top);
                stack.push(newVal);
            }
            else stack.push(Integer.valueOf(op));
        }
        int total = 0;
        for (int num : stack)
            total += num;
        return total;
    }

}
