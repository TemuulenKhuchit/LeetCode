package LeetCode.Stack;

import java.util.Stack;

public class Medium735 {

    // Medium 735. Asteroid Collision
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int curr : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && st.peek() > 0 && curr < 0) {
                if (st.peek() < curr * -1) {
                    st.pop();
                    continue;
                }
                else if (st.peek() + curr == 0)
                    st.pop();

                flag = false;
                break;
            }

            if (flag)
                st.push(curr);
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--)
            res[i] = st.pop();

        return res;
    }
}
