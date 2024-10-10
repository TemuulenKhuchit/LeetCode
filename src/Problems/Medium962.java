package Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Medium962 {

    public static void main(String[] args) {

        maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5});
        maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1});
        maxWidthRamp(new int[]{3, 3, 3});
        maxWidthRamp(new int[]{2, 7, 2, 2, 7});
    }

    public static int maxWidthRamp2(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] <= nums[j] && nums[j] - nums[i] >= 0)
                    max = Math.max(max, j - i);

        return max;
    }

    public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            if (stack.isEmpty() || nums[i] < nums[stack.peek()])
                stack.push(i);

        int maxWidth = 0;
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }


}
