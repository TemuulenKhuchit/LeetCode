package LeetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Easy225 {

    public static void main(String[] args) {
        Easy225 myStack = new Easy225();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.pop();
        myStack.empty();
    }

    // Easy 225. Implement Stack using Queues
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        int n = queue.size();
        while (n > 1) {
            queue.add(queue.remove());
            n--;
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
