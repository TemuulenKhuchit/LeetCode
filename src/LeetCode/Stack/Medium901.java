package LeetCode.Stack;

import java.util.Stack;

public class Medium901 {
    Stack<int[]> st = new Stack<>();

    public int next(int price) {
        int res = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) res += st.pop()[1];
        st.push(new int[]{price, res});
        return res;
    }
}
