package LeetCode.Stack;

import java.util.Stack;

public class Easy232 {

    public static void main(String[] args) {
        Easy232 myQueue = new Easy232();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.peek();
        myQueue.pop();
        myQueue.empty();

    }

    // Easy 232. Implement Queue using Stacks
    private Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty())
            temp.push(stack.pop());
        stack.push(x);
        while (!temp.isEmpty())
            stack.push(temp.pop());
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}
