package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hard84 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    // Hard 84. Largest Rectangle in Histogram
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWidth = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }

        return maxArea;
    }
}
