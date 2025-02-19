package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Medium739 {

    // Medium 739. Daily Temperatures
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int currDay = 0; currDay < n; currDay++) {
            int currTemp = temperatures[currDay];
            while (!st.isEmpty() && temperatures[st.peek()] < currTemp) {
                int prevDay = st.pop();
                res[prevDay] = currDay - prevDay;
            }
            st.push(currDay);
        }

        return res;
    }
}
